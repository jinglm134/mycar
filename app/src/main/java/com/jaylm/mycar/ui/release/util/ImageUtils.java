package com.jaylm.mycar.ui.release.util;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by lenovo on 2018/4/22.
 */

public class ImageUtils {
    public static void showImage(Context activity, String url, ImageView ivHome) {
        try {
             Glide.with(activity)
                    .load(url)
                    .centerCrop()
                    .into(ivHome);
        } catch (Exception e) {
        }
    }
}