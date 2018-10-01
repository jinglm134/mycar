package com.jaylm.mycar.ui.release;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.jaylm.mycar.R;
import com.jaylm.mycar.ui.MainActivity;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;



public class SplashActivity extends AppCompatActivity {
    private long appid;
    private Timer timer;

    public void goDebug(){
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.setStatusBarColor(Color.parseColor("#ff0000"));
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
        setContentView(R.layout.activity_splash_1);
        String channelName = getAppMetaData(this, "UMENG_CHANNEL");
        switch (channelName) {
            case "_360":
                appid = 20180809190233L;
                break;
            case "baidu":
                appid = 20180809190233L;
                break;
            case "huawei":
                break;
            case "xiaomi":
                appid = 20180809190233L;
                break;
            case "yingyongbao":
                appid = 20180809190233L;
                break;
            case "meizu":
            default:
                appid = 20180820179001L;
//                appid = 201809291442001L;
                break;
        }

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                loadData();
            }
        }, 1000);

    }

    private void loadData() {
        OkGo.<String>post("http://xm.anzhuo9.com/index.php?s=/api/Version/index")
                .params("app_id", appid)
                .params("type", "android")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body());
                            int status = jsonObject.optInt("status");
                            String data = jsonObject.optString("data");

                            if (status != 1) {
                                //请求状态码错误，直接测试版
                                goDebug();
                            } else {
                                VersionData versionData = new Gson().fromJson(data, VersionData.class);
                                String version = versionData.getVersion();
                                if (version != null && version.contains("2.0")) {
                                    //正式版
                                    NewWebActivity.newInstance(SplashActivity.this, versionData);
                                    finish();
                                } else {
                                    //测试版
                                    goDebug();
                                }
                            }

                        } catch (JSONException e) {
                            //解析异常，直接测试版
                            goDebug();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        //error，直接测试版
                        goDebug();
                    }
                });
    }


    private String getAppMetaData(Context context, String channel) {
        String channelNumber = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelNumber = applicationInfo.metaData.getString(channel);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return channelNumber;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    public class VersionData implements Serializable {
        /**
         * id : 440
         * home_url :
         * kc_url :
         * service_url :
         * buttonarr : 主页,后退,客服,快充,刷新
         * buttonimage : http://142.4.117.17:8001/index/6.9/11.png,http://142.4.117.17:8001/index/6.9/12.png,http://142.4.117.17:8001/index/6.9/13.png,http://142.4.117.17:8001/index/6.9/14.png,http://142.4.117.17:8001/index/6.9/15.png
         * app_id : 20180607172841
         * platform : 百度
         * version : 1.0
         * active : -1
         */

        private String id;
        private String home_url;
        private String kc_url;
        private String service_url;
        private String buttonarr;
        private String buttonimage;
        private String app_id;
        private String platform;
        private String version;
        private String active;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHome_url() {
            return home_url;
        }

        public void setHome_url(String home_url) {
            this.home_url = home_url;
        }

        public String getKc_url() {
            return kc_url;
        }

        public void setKc_url(String kc_url) {
            this.kc_url = kc_url;
        }

        public String getService_url() {
            return service_url;
        }

        public void setService_url(String service_url) {
            this.service_url = service_url;
        }

        public String getButtonarr() {
            return buttonarr;
        }

        public void setButtonarr(String buttonarr) {
            this.buttonarr = buttonarr;
        }

        public String getButtonimage() {
            return buttonimage;
        }

        public void setButtonimage(String buttonimage) {
            this.buttonimage = buttonimage;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }
    }
}

