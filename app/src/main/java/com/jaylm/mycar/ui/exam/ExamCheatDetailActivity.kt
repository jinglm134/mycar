package com.jaylm.mycar.ui.exam

import android.annotation.SuppressLint
import android.graphics.Color
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterExamCheatDetail
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.ExamCheatDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_cheat_detail.*
import org.jetbrains.anko.backgroundColor
import org.json.JSONObject


/**
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamCheatDetailActivity : BaseActivity() {

    private lateinit var mUrl: String
    private var mId: Long = 0L
    private lateinit var mData: ArrayList<ExamCheatDetailBean>
    private lateinit var mAdapter: AdapterExamCheatDetail
    override fun bindLayout(): Int {
        return R.layout.activity_cheat_detail
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        mUrl = bundle.getString("url", "")
        mId = bundle.getLong("id", 0L)

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {
        super.initView()
        setHeader("秘籍详情")

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
        webView.loadUrl(mUrl)



        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mData = ArrayList()
        mAdapter = AdapterExamCheatDetail()
        recyclerView.adapter = mAdapter
        loadData()
    }

    private fun loadData() {
        WebList.Onecommentlist(mId, object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val result = JSONObject(response.body()).optString("result")
                val list = JSONObject(result).optString("list")
                val commentlist = JSONObject(list).optString("commentlist")
                val data = GsonUtils.parseJsonArrayWithGson(commentlist, ExamCheatDetailBean::class.java)
                mData.clear()
                mData.addAll(data)

                mAdapter.setNewData(mData.filter { it.usertype != 0 && it.groups != null && it.groups.size > 0 })//筛选出usertype!=0后的集合,usertype=0为广告
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
}