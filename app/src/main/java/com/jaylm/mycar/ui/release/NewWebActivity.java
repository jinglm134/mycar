package com.jaylm.mycar.ui.release;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaylm.mycar.R;
import com.jaylm.mycar.ui.release.util.ImageUtils;
import com.jaylm.mycar.ui.release.util.ToastUtils;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by lenovo on 2018/1/6.
 */

public class NewWebActivity extends AppCompatActivity implements View.OnClickListener {


    protected AgentWeb mAgentWeb;
    private ProgressDialog mProgressDialog;
    private AlertDialog mAlertDialog;
    private SplashActivity.VersionData mBean;
    private TextView mTvHome;
    private TextView mTvTwo;
    private TextView mTvThree;
    private TextView mTvThree04;
    private TextView mTvThree05;
    private ImageView mIvHome;
    private ImageView mIvTwo;
    private ImageView mIvThree;
    private ImageView mIvThree04;
    private ImageView mIvThree05;
    private LinearLayout mLinl;


    private List<TextView> tvMenu;
    private List<ImageView> ivMenu;

    public static void newInstance(Context context, SplashActivity.VersionData person) {
        Intent intent = new Intent(context, NewWebActivity.class);
        intent.putExtra("bean", person);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#ff0000"));
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        setContentView(R.layout.activity_web_release);

        mBean = (SplashActivity.VersionData) getIntent().getSerializableExtra("bean");

        initView();
        initWebView();
    }


    //设置底部导航按钮文字和图标
    private void initView() {
        RelativeLayout mLayoutHome = (RelativeLayout) findViewById(R.id.layout_home);
        RelativeLayout mLayoutTwo = (RelativeLayout) findViewById(R.id.layout_two);
        RelativeLayout mLayoutThree = (RelativeLayout) findViewById(R.id.layout_three);
        RelativeLayout mLayoutThree04 = (RelativeLayout) findViewById(R.id.layout_three04);
        RelativeLayout mLayoutThree05 = (RelativeLayout) findViewById(R.id.layout_three05);

        mTvHome = (TextView) findViewById(R.id.tv_home);
        mTvTwo = (TextView) findViewById(R.id.tv_two);
        mTvThree = (TextView) findViewById(R.id.tv_three);
        mTvThree04 = (TextView) findViewById(R.id.tv_three04);
        mTvThree05 = (TextView) findViewById(R.id.tv_three05);

        mIvHome = (ImageView) findViewById(R.id.iv_home);
        mIvTwo = (ImageView) findViewById(R.id.iv_two);
        mIvThree = (ImageView) findViewById(R.id.iv_three);
        mIvThree04 = (ImageView) findViewById(R.id.iv_three04);
        mIvThree05 = (ImageView) findViewById(R.id.iv_three05);
        mLinl = (LinearLayout) findViewById(R.id.linl);

        //点击事件
        mLayoutHome.setOnClickListener(this);
        mLayoutTwo.setOnClickListener(this);
        mLayoutThree.setOnClickListener(this);
        mLayoutThree04.setOnClickListener(this);
        mLayoutThree05.setOnClickListener(this);


        tvMenu = new ArrayList<>();
        ivMenu = new ArrayList<>();
        tvMenu.add(mTvHome);
        tvMenu.add(mTvTwo);
        tvMenu.add(mTvThree);
        tvMenu.add(mTvThree04);
        tvMenu.add(mTvThree05);

        ivMenu.add(mIvHome);
        ivMenu.add(mIvTwo);
        ivMenu.add(mIvThree);
        ivMenu.add(mIvThree04);
        ivMenu.add(mIvThree05);
    }

    private void initWebView() {
        showProgressBarDialog();
        //初始化首页
        setWebView(mBean.getHome_url());
        setData();
    }

    private void setWebView(String url) {

        if (mAgentWeb == null) {
            mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                    .setAgentWebParent(mLinl, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                    .useDefaultIndicator()// 使用默认进度条
                    .defaultProgressBarColor() // 使用默认进度条颜色
                    .setReceivedTitleCallback(new ChromeClientCallbackManager.ReceivedTitleCallback() {
                        @Override
                        public void onReceivedTitle(WebView view, String title) {

                        }
                    }) //设置 Web 页面的 title 回调
                    .setWebChromeClient(mWebChromeClient)
                    .setWebViewClient(mWebViewClient)
                    .setSecutityType(AgentWeb.SecurityType.strict)
                    .createAgentWeb()//
                    .ready()
                    .go(url);
        } else {
            mAgentWeb.getLoader().loadUrl(url);
        }
    }

    private void setData() {

        //设置button名字
        String buttonArr = mBean.getButtonarr();
        String[] split1 = buttonArr.split(",");
        mTvHome.setText(split1[0]);
        mTvTwo.setText(split1[1]);
        mTvThree.setText(split1[2]);
        mTvThree04.setText(split1[3]);
        mTvThree05.setText(split1[4]);


        //设置图片
        String buttonImage = mBean.getButtonimage();
        String[] split = buttonImage.split(",");
        ImageUtils.showImage(this, split[0], mIvHome);
        ImageUtils.showImage(this, split[1], mIvTwo);
        ImageUtils.showImage(this, split[2], mIvThree);
        ImageUtils.showImage(this, split[3], mIvThree04);
        ImageUtils.showImage(this, split[4], mIvThree05);

        // 选中首页
        mTvHome.setSelected(true);
        checkTvIvIsSelected(0);
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressDialog.dismiss();
            }
        }
    };

    /**
     * 设置底部导航图片选择颜色
     *
     */
    private void selectImageViewColor(ImageView view, boolean b) {
        if (b) {
            setIconColor(view, 255, 0, 0, 255); //选中红色
        } else {
            setIconColor(view, 0, 0, 0, 255);  //未选择 黑色
        }
    }


    //设置图标的颜色
    private void setIconColor(ImageView icon, int r, int g, int b, int a) {
        float[] colorMatrix = new float[]{
                1, 0, 0, 0, r,
                0, 1, 0, 0, g,
                0, 0, 1, 0, b,
                0, 0, 0, 1, 0};
        icon.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }




    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layout_home://主页
                showProgressBarDialog();
                mAgentWeb.getLoader().loadUrl(mBean.getHome_url());
                checkTvMenuIsSelected(mTvHome);
                checkTvIvIsSelected(0);
                break;
            case R.id.layout_two: //后退
                if (mAgentWeb.back()) {
                    showProgressBarDialog();
                    mAgentWeb.back();
                }else{
                    ToastUtils.showShortToast(this,"已经是第一页了");
                }
                checkTvMenuIsSelected(mTvTwo);
                checkTvIvIsSelected(1);
                break;
            case R.id.layout_three: //客服
                showProgressBarDialog();
                String service_url = mBean.getService_url();
                String s = service_url.replace("amp;", "");
                mAgentWeb.getLoader().loadUrl(s);
                checkTvMenuIsSelected(mTvThree);
                checkTvIvIsSelected(2);
                break;
            case R.id.layout_three04://快充
                showProgressBarDialog();
                mAgentWeb.getLoader().loadUrl(mBean.getKc_url());
                checkTvMenuIsSelected(mTvThree04);
                checkTvIvIsSelected(3);
                break;
            case R.id.layout_three05: //刷新
                showProgressBarDialog();
                mAgentWeb.getLoader().reload();
                checkTvMenuIsSelected(mTvThree05);
                checkTvIvIsSelected(4);
                break;
            default:
                break;
        }

    }


    /**
     * 检查底部导航栏图标是否选中
     *
     * @param target
     */
    private void checkTvMenuIsSelected(TextView target) {
        for (TextView tv : tvMenu) {
            if (tv == target)
                tv.setSelected(true);
            else
                tv.setSelected(false);
        }
    }

    /**
     * 设置图标和文字选中的颜色
     *
     * @param index
     */
    private void checkTvIvIsSelected(int index) {
        for (int i = 0; i < tvMenu.size(); i++) {
            if (i == index) {
                tvMenu.get(i).setSelected(true);
                  selectImageViewColor(ivMenu.get(i), true);
            } else {
                tvMenu.get(i).setSelected(false);
                 selectImageViewColor(ivMenu.get(i), false);
            }
        }

    }


    private void showProgressBarDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setMessage("我们正为您选择最快的路线,\n请耐心等待");
        mProgressDialog.setCanceledOnTouchOutside(false); // 点击加载框以外的区域
        mProgressDialog.show();
    }

    private void showDialog() {

        if (mAlertDialog == null)
            mAlertDialog = new AlertDialog.Builder(this)
                    .setMessage("您确定要关闭该页面吗?")
                    .setNegativeButton("再逛逛", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mAlertDialog != null) {
                                mAlertDialog.dismiss();
                            }
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mAlertDialog != null) {
                                mAlertDialog.dismiss();
                            }
                            finish();
                        }
                    }).create();
        mAlertDialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }


    @Override
    public void onBackPressed() {
        showDialog();
    }

}
