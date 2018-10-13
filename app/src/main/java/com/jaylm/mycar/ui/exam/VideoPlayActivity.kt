package com.jaylm.mycar.ui.exam

import android.annotation.SuppressLint
import android.graphics.Color
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.jzvd.Jzvd
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.ExamKM2Video
import com.jaylm.mycar.bean.exam.KM2VideoDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_video_play.*
import org.jetbrains.anko.backgroundColor

/**
 * Created by jaylm
 * on 2018/10/13.
 */
class VideoPlayActivity : BaseActivity() {

    private lateinit var data: ExamKM2Video.VideosBean

    override fun bindLayout(): Int {
        return R.layout.activity_video_play
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        data = bundle.getParcelable("data")
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        super.initView()

        webView.settings.domStorageEnabled = true
        //解决图片不显示
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        webView.settings.blockNetworkImage = false
        /*设置编码方式*/
        webView.settings.defaultTextEncodingName = "utf-8"
        /*设置背景透明*/
        webView.backgroundColor = Color.argb(0, 0, 0, 0)
        /*设置支持js*/
        webView.settings.javaScriptEnabled = true
        /*设置支持缩放*/
        webView.settings.setSupportZoom(true)
        webView.webViewClient = ReWebViewClient()


        setHeader(data.title)
        videoPlayer.setUp(data.playurl, data.title, Jzvd.SCREEN_WINDOW_NORMAL)
        videoPlayer.thumbImageView.setImageURI(Uri.parse(data.imageBig))
        loadData()

    }


    private fun loadData() {
        WebList.km2_detail(data.topicid.toLong(), object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val data = GsonUtils.parseJsonWithGson(response.body(), KM2VideoDetailBean::class.java)
                webView.loadUrl(data.result.media.detailPage)

            }
        })
    }

    @Suppress("OverridingDeprecatedMember")
    inner class ReWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            /**设置点击网页里面的链接无效*/
            return true
        }


        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            handler?.proceed()
        }
    }


    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }


    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}