package com.jaylm.mycar.ui.release.util;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jaylm.mycar.application.BaseApp;


/**
 * Created by lenovo on 2018/4/22.
 */

public class ImageUtils {
    public static void showImage(Context activity, String url, ImageView ivHome) {
        try {
            Glide.with(activity)
                    .load(url)
                    .into(ivHome);
        } catch (Exception e) {
        }
    }

    public static void showImage(Context activity, String url, ImageView ivHome, @DrawableRes int placeholder) {
        try {
            Glide.with(activity)
                    .load(url)
                    .placeholder(BaseApp.getInstance().getResources().getDrawable(placeholder))
                    .into(ivHome);
        } catch (Exception e) {
        }
    }
}