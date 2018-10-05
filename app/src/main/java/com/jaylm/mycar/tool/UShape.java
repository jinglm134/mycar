package com.jaylm.mycar.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorRes;
import android.view.View;

import com.jaylm.mycar.application.BaseApp;
import com.jaylm.mycar.ui.release.util.SizeUtils;


/**
 * Shape,Selector图片工具
 * Created by ${jaylm}
 * on 2018/1/27.
 */
public class UShape {

    /**
     * 图片圆形
     *
     * @param bitmap Bitmap
     * @return Bitmap
     */
    private static Bitmap getCircleBitmap(Bitmap bitmap) {
        int min = 200;
        if (bitmap != null) {
            Bitmap outBitmap = Bitmap.createBitmap(min,
                    min, Bitmap.Config.ARGB_8888);

            Paint paint = new Paint();
            paint.setAntiAlias(true);

            Rect rect = new Rect(0, 0, min, min);

            Canvas canvas = new Canvas(outBitmap);
            canvas.drawCircle(min / 2, min / 2, min / 2, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return outBitmap;
        }

        return null;
    }

    /**
     * 将图片圆角,默认4dp圆角
     *
     * @param bitmap Bitmap
     * @return Bitmap
     */
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
        return getRoundedCornerBitmap(bitmap, SizeUtils.dp2px(BaseApp.getInstance(), 4));
    }

    private static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int radius) {
        int min = 200;
        if (bitmap != null) {
            Bitmap outBitmap = Bitmap.createBitmap(min,
                    min, Bitmap.Config.ARGB_8888);

            Paint paint = new Paint();
            paint.setAntiAlias(true);

            Rect rect = new Rect(0, 0, min, min);
            RectF rectF = new RectF(rect);

            Canvas canvas = new Canvas(outBitmap);
            canvas.drawRoundRect(rectF, radius, radius, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return outBitmap;
        }
        return null;
    }

    /**
     * 圆角纯色ShapeDrawable
     *
     * @param color  颜色  R.color.c8
     * @param corner 圆角大小,单位dp,没有圆角传0
     * @return RoundRectShape(float[] outerRadii, RectF inset, float[] innerRadii) :指定一个外部（圆角）矩形 和 一个 可选的 内部（圆角）矩形。
     */
    public static ShapeDrawable getCornerDrawable(int color, int corner) {
        float[] corners = new float[8];
        for (int i = 0; i < corners.length; i++) {
            corners[i] = corner;
        }
        return getCornerDrawable(color, corners);
    }

    /**
     * 圆角纯色
     *
     * @param color   颜色
     * @param corners 圆角大小,单位px，8个角度不一样时使用，八个角度按顺序依次是左上 右上 右下 左下
     * @return RoundRectShape(float[] outerRadii, RectF inset, float[] innerRadii) :指定一个外部（圆角）矩形 和 一个 可选的 内部（圆角）矩形。
     */
    private static ShapeDrawable getCornerDrawable(int color, float[] corners) {
        if (corners.length < 8) {
            return null;
        }
        Context context = BaseApp.getInstance();
        float[] martCorners = new float[corners.length];
        for (int i = 0; i < corners.length; i++) {
            martCorners[i] = SizeUtils.dp2px(context, corners[i]);
        }

        ShapeDrawable drawable = new ShapeDrawable(new RoundRectShape(martCorners, null, null));
        drawable.getPaint().setColor(color);
        drawable.getPaint().setStyle(Paint.Style.FILL);
        return drawable;
    }

    /**
     * 有各种效果的圆角按钮Drawable,padding 默认为0dp，有需求可修改padding
     * setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null)
     *
     * @param normalColor   原本的颜色,该值必须有
     * @param checkedColor  state_check=true选中的颜色
     * @param selectedColor state_selector=true选中的颜色
     * @param pressColor    state_press=true按下的颜色
     * @param corner        圆角大小
     */
    private static StateListDrawable getSelectorDrawable(int normalColor, int checkedColor, int selectedColor, int pressColor, int corner) {
        StateListDrawable listDrawable = new StateListDrawable();

        if (checkedColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_checked}, setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null));
            listDrawable.addState(new int[]{android.R.attr.state_checked}, setShapeDrawablePadding(getCornerDrawable(checkedColor, corner), null));
        }
        if (selectedColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_selected}, setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null));
            listDrawable.addState(new int[]{android.R.attr.state_selected}, setShapeDrawablePadding(getCornerDrawable(selectedColor, corner), null));
        }
        if (pressColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_pressed}, setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null));
            listDrawable.addState(new int[]{android.R.attr.state_pressed}, setShapeDrawablePadding(getCornerDrawable(pressColor, corner), null));
        }
        if (normalColor != 0) {
            listDrawable.addState(new int[]{}, setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null));
        }
        return listDrawable;
    }


    /**
     * checkedSelector
     *
     * @param normalColor  原本的颜色
     * @param checkedColor state_check=true选中的颜色
     * @param corner       圆角大小
     */
    public static StateListDrawable getCheckedDrawable(int normalColor, int checkedColor, int corner) {
        return getSelectorDrawable(normalColor, checkedColor, 0, 0, corner);
    }

    /**
     * SelectedSelector
     *
     * @param normalColor   原本的颜色
     * @param selectedColor state_selector=true选中的颜色
     * @param corner        圆角大小
     */
    public static StateListDrawable getSelectedDrawable(int normalColor, int selectedColor, int corner) {
        return getSelectorDrawable(normalColor, 0, selectedColor, 0, corner);
    }

    /**
     * pressedSelector
     *
     * @param normalColor 原本的颜色
     * @param pressColor  state_press=true按下的颜色
     * @param corner      圆角大小
     */
    public static StateListDrawable getPressedDrawable(int normalColor, int pressColor, int corner) {
        return getSelectorDrawable(normalColor, 0, 0, pressColor, corner);
    }


    /*******************************圆角大小不一致时调用********************************/


    /**
     * 有各种效果的圆角按钮Drawable,padding 默认为0dp，有需求可修改padding
     * setShapeDrawablePadding(getCornerDrawable(normalColor, corner), null)
     *
     * @param normalColor   原本的颜色,该值必须有
     * @param checkedColor  state_check=true选中的颜色
     * @param selectedColor state_selector=true选中的颜色
     * @param pressColor    state_press=true按下的颜色
     * @param corners       圆角大小
     */
    private static StateListDrawable getSelectorDrawable(int normalColor, int checkedColor, int selectedColor, int pressColor, float[] corners) {
        StateListDrawable listDrawable = new StateListDrawable();

        if (checkedColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_checked}, setShapeDrawablePadding(getCornerDrawable(normalColor, corners), null));
            listDrawable.addState(new int[]{android.R.attr.state_checked}, setShapeDrawablePadding(getCornerDrawable(checkedColor, corners), null));
        }
        if (selectedColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_selected}, setShapeDrawablePadding(getCornerDrawable(normalColor, corners), null));
            listDrawable.addState(new int[]{android.R.attr.state_selected}, setShapeDrawablePadding(getCornerDrawable(selectedColor, corners), null));
        }
        if (pressColor != 0) {
            listDrawable.addState(new int[]{-android.R.attr.state_pressed}, setShapeDrawablePadding(getCornerDrawable(normalColor, corners), null));
            listDrawable.addState(new int[]{android.R.attr.state_pressed}, setShapeDrawablePadding(getCornerDrawable(pressColor, corners), null));
        }
        if (normalColor != 0) {
            listDrawable.addState(new int[]{}, setShapeDrawablePadding(getCornerDrawable(normalColor, corners), null));
        }
        return listDrawable;
    }


    /**
     * checkedSelector
     *
     * @param normalColor  原本的颜色
     * @param checkedColor state_check=true选中的颜色
     * @param corners      圆角大小
     */
    public static StateListDrawable getCheckedDrawable(int normalColor, int checkedColor, float[] corners) {
        return getSelectorDrawable(normalColor, checkedColor, 0, 0, corners);
    }

    /**
     * SelectedSelector
     *
     * @param normalColor   原本的颜色
     * @param selectedColor state_selector=true选中的颜色
     * @param corners       圆角大小
     */
    public static StateListDrawable getSelectedDrawable(int normalColor, int selectedColor, float[] corners) {
        return getSelectorDrawable(normalColor, 0, selectedColor, 0, corners);
    }

    /**
     * pressedSelector
     *
     * @param normalColor 原本的颜色
     * @param pressColor  state_press=true按下的颜色
     * @param corners     圆角大小
     */
    public static StateListDrawable getPressedDrawable(int normalColor, int pressColor, float[] corners) {
        return getSelectorDrawable(normalColor, 0, 0, pressColor, corners);
    }


    /**
     * 给ShapeDrawable设置padding
     *
     * @param drawable ShapeDrawable
     * @param padding  间距
     * @return ShapeDrawable
     */
    private static ShapeDrawable setShapeDrawablePadding(ShapeDrawable drawable, int[] padding) {
        if (drawable != null) {
            if (padding != null && padding.length > 3) {
                drawable.setPadding(padding[0], padding[1], padding[2], padding[3]);
            }
        }
        return drawable;
    }

    /**
     * 圆角边框1dp
     *
     * @param color   颜色
     * @param corners 圆角大小,单位px，8个角度不一样时使用，八个角度按顺序依次是左上 右上 右下 左下
     * @return RoundRectShape(float[] outerRadii, RectF inset, float[] innerRadii) :指定一个外部（圆角）矩形 和 一个 可选的 内部（圆角）矩形。
     */
    private static ShapeDrawable getStrokeDrawable(int color, float[] corners) {
        if (corners.length < 8) {
            return null;
        }
        Context context = BaseApp.getInstance();
        float[] martCorners = new float[corners.length];
        for (int i = 0; i < corners.length; i++) {
            martCorners[i] = SizeUtils.dp2px(context, corners[i]);
        }
        ShapeDrawable drawable = new ShapeDrawable(new RoundRectShape(martCorners, null, null));
        drawable.getPaint().setColor(color);
        drawable.getPaint().setStrokeWidth(SizeUtils.dp2px(context, 1));
        drawable.getPaint().setAntiAlias(true);
        drawable.getPaint().setStyle(Paint.Style.STROKE);
        return drawable;
    }

    /**
     * 圆角边框1dp
     *
     * @param color  颜色
     * @param corner 圆角大小,单位px，8个角度不一样时使用，八个角度按顺序依次是左上 右上 右下 左下
     * @return RoundRectShape(float[] outerRadii, RectF inset, float[] innerRadii) :指定一个外部（圆角）矩形 和 一个 可选的 内部（圆角）矩形。
     */
    public static ShapeDrawable getStrokeDrawable(int color, int corner) {
        float[] corners = new float[8];
        for (int i = 0; i < corners.length; i++) {
            corners[i] = corner;
        }
        return getStrokeDrawable(color, corners);
    }

    /**
     * 纯色圆，如果View是长方形则显示为椭圆
     *
     * @param color 颜色
     * @return drawable
     */
    public static ShapeDrawable getCircleDrawable(int color) {
        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(color);
        drawable.getPaint().setStyle(Paint.Style.FILL);
        return drawable;
    }

    /**
     * 设置显示背景图片
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("NewApi")
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    /**
     * 获取颜色
     *
     * @param rId rId
     * @return int color
     */
    public static int getColor(@ColorRes int rId) {
        Context context = BaseApp.getInstance();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            return context.getColor(rId);
        } else {
            return context.getResources().getColor(rId);
        }
    }
}
