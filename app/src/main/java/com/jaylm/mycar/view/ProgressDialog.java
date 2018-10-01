package com.jaylm.mycar.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import com.jaylm.mycar.R;

import java.util.Timer;
import java.util.TimerTask;


public class ProgressDialog extends Dialog {

    private Timer mTimer;
    private static final long showTime = 6000L;

    private ProgressDialog(@NonNull Context context, CharSequence charSequence) {
        super(context, R.style.CustomerDialogStyle);
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") View rootView = inflater.inflate(R.layout.dialog_progress, null);
        TextView tvMessage = rootView.findViewById(R.id.tv_message);
        tvMessage.setText(charSequence);

        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setContentView(rootView);
    }

    public ProgressDialog(@NonNull Context context) {
        this(context, "请求网络中...");
    }

    @Override
    public void show() {
        super.show();
        if (mTimer == null) {
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isShowing()) {
                    dismiss();
                }
            }
        }, showTime);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

}
