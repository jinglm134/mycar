package com.jaylm.mycar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.jaylm.mycar.ui.release.util.ImageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * banner
 * Created by ${jaylm}
 * on 2017/12/2.
 */
@SuppressWarnings("deprecation")
public class Banner extends Gallery implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener, OnTouchListener {
    /**
     * 显示的Activity
     */
    private Context mContext;
    /**
     * 条目单击事件接口
     */
    private OnBannerItemClickListener mOnBannerItemClickListener;
    /**
     * 图片切换时间
     */
    private int mSwitchTime;
    /**
     * 自动滚动的定时器
     */
    private Timer mTimer;
    /**
     * 圆点容器
     */
    private LinearLayout llt_dot;
    /**
     * 当前选中的数组索引
     */
    private int curIndex = 0;
    /**
     * 上次选中的数组索引
     */
    private int oldIndex = 0;
    /**
     * 圆点选中时的背景ID
     */
    private int mFocusedId;
    /**
     * 圆点正常时的背景ID
     */
    private int mNormalId;
    /**
     * 图片资源ID
     */
    private int[] mAdsId;
    /**
     * 图片网络路径数组
     */
    private String[] mUris;
    /**
     * ImageView
     */
    private List<ImageView> listImgs;
    /**
     * 处理定时滚动任务
     */
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            /**不包含spacing会导致onKeyDown()失效!!!onKeyDown()前先调用onScroll(null,null,1,0)可处理*/
            onScroll(null, null, 1, 0);
            onKeyDown(KeyEvent.KEYCODE_DPAD_RIGHT, null);
        }
    };

    public Banner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public Banner(Context context) {
        super(context);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param context    显示的Activity ,不能为null
     * @param urls       图片的网络路径数组 ,为空时 加载 adsId
     * @param adsId      图片组资源ID ,测试用
     * @param switchTime 图片切换时间(毫秒) ,0为不自动切换
     * @param ovalLayout 圆点容器 ,可为空
     * @param focusedId  圆点选中时的背景ID,圆点容器可为空写0
     * @param normalId   圆点正常时的背景ID,圆点容器为空写0
     */
    public void start(Context context, String[] urls, int[] adsId,
                      int switchTime, LinearLayout ovalLayout, int focusedId, int normalId) {
        this.mContext = context;
        this.mUris = urls;
        this.mAdsId = adsId;
        this.mSwitchTime = switchTime;
        this.llt_dot = ovalLayout;
        this.mFocusedId = focusedId;
        this.mNormalId = normalId;

        /** 初始化图片组 */
        initImages();
        setAdapter(new AdAdapter());
        this.setOnItemClickListener(this);
        this.setOnTouchListener(this);
        this.setOnItemSelectedListener(this);
        this.setSoundEffectsEnabled(false);
        /** 动画时间 */
        this.setAnimationDuration(700);
        /**
         * 未选中项目的透明度 不包含spacing会导致onKeyDown()失效!!!
         * 失效onKeyDown()前先调用onScroll(null,1,0)可处理
         */
        this.setUnselectedAlpha(1);
        /** 取靠近中间 图片数组的整倍数 */
        setSpacing(0);
        /** 默认选中中间位置为起始位置 */
        setSelection((getCount() / 2 / listImgs.size()) * listImgs.size());
        setFocusableInTouchMode(true);
        /** 初始化圆点 */
        initDotLayout();
        /** 开始自动滚动任务 */
        startTimer();
    }

    /**
     * 初始化图片组
     */
    private void initImages() {
        /** 图片集合 */
        listImgs = new ArrayList<>();
        int len = mUris != null ? mUris.length : mAdsId.length;
        for (int i = 0; i < len; i++) {
            /** 实例化ImageView的对象 */
            ImageView imageView = new ImageView(mContext);
            /** 设置缩放方式 */
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));
            if (mUris == null) {
                /** 加载本地图片*/
                imageView.setImageResource(mAdsId[i]);
            } else {
                /**加载网络图片*/
                ImageUtils.showImage(mContext, mUris[i], imageView);
            }
            listImgs.add(imageView);
        }
    }

    /**
     * 初始化圆点
     */
    private void initDotLayout() {
        llt_dot.setVisibility(View.VISIBLE);
        if (llt_dot != null && listImgs.size() < 2) {
            /**如果只有一张图时不显示圆点容器*/
            llt_dot.getLayoutParams().height = 0;
        } else if (llt_dot != null) {
            llt_dot.removeAllViews();
            /** 圆点的大小是 圆点窗口的 70%;*/
            int ovalHeight = (int) (llt_dot.getLayoutParams().height * 0.6);
            int ovalWidth = (int) (llt_dot.getLayoutParams().height * 0.6);
            /** 圆点的左右外边距是 圆点窗口的 20%;*/
            int ovalMargin = (int) (llt_dot.getLayoutParams().height * 0.2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ovalWidth, ovalHeight);
            layoutParams.setMargins(ovalMargin, 0, ovalMargin, 0);
            for (int i = 0; i < listImgs.size(); i++) {
                /** 圆点*/
                View v = new View(mContext);
                v.setLayoutParams(layoutParams);
                v.setBackgroundResource(mNormalId);
                llt_dot.addView(v);
            }
            /**设置第一个圆点默认选中*/
            llt_dot.getChildAt(0).setBackgroundResource(mFocusedId);
        }
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        int kEvent;
        if (isScrollingLeft(e1, e2)) {
            /**检查是否向左滑动,KeyEvent.KEYCODE_DPAD_LEFT*/
            kEvent = 21;
        } else {
            /** 检查是否向右滑动,KeyEvent.KEYCODE_DPAD_RIGHT*/
            kEvent = 22;
        }
        onKeyDown(kEvent, null);
        return true;

    }

    /**
     * 检查是否向左滑动
     */
    private boolean isScrollingLeft(MotionEvent e1, MotionEvent e2) {
        return e2.getX() > (e1.getX() + 50);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (MotionEvent.ACTION_UP == event.getAction()
                || MotionEvent.ACTION_CANCEL == event.getAction()) {
            /* 开始自动滚动任务*/
            startTimer();
        } else {
            /* 停止自动滚动任务*/
            stopTimer();
        }
        return false;
    }

    /**
     * 图片切换事件
     */
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        curIndex = position % listImgs.size();
        if (llt_dot != null && listImgs.size() > 1) {
            /* 切换圆点*/
            llt_dot.getChildAt(oldIndex).setBackgroundResource(mNormalId);
            llt_dot.getChildAt(curIndex).setBackgroundResource(mFocusedId);
            oldIndex = curIndex;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    /**
     * 项目点击事件
     */
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                            long arg3) {
        if (mOnBannerItemClickListener != null) {
            mOnBannerItemClickListener.OnBannerItemClick(curIndex);
        }
    }

    /**
     * 设置项目点击事件监听
     */
    public void setOnBannerItemClickListener(
            OnBannerItemClickListener listener) {
        mOnBannerItemClickListener = listener;
    }

    /**
     * 停止自动滚动任务
     */
    public void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    /**
     * 启动自动滚动任务 图片大于1张才滚动
     */
    public void startTimer() {
        if (mTimer == null && listImgs.size() > 1 && mSwitchTime > 0) {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                public void run() {
                    handler.sendMessage(handler.obtainMessage(1));
                }
            }, mSwitchTime, mSwitchTime);
        }
    }

    /**
     * 项目点击事件监听器接口
     */
    public interface OnBannerItemClickListener {
        /**
         * @param curIndex 当前条目在数组中的下标
         */
        void OnBannerItemClick(int curIndex);
    }

    /**
     * 无限循环适配器
     */
    class AdAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            /**如果只有一张图时不滚动*/
            if (listImgs.size() < 2) {
                return listImgs.size();
            }
            return Integer.MAX_VALUE;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return listImgs.get(position % listImgs.size());
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }
}
