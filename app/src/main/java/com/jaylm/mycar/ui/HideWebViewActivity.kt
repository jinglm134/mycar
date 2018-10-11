package com.jaylm.mycar.ui

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.just.library.AgentWeb
import kotlinx.android.synthetic.main.activity_webview.*


/**
 * Created by jaylm
 * on 2018/10/3.
 */
class HideWebViewActivity : BaseActivity() {
    private lateinit var mUrl: String
    private lateinit var mName: String
    private var mAgentWeb: AgentWeb? = null
    override fun bindLayout(): Int {
        return R.layout.activity_hidewebview
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        mUrl = bundle.getString("url")
        mName = bundle.getString("name", getString(R.string.app_name))
    }

    override fun initView() {
        super.initView()
        setHeader(mName)

        if (mAgentWeb == null) {
            mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                    .setAgentWebParent(ll_webView, LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                    .useDefaultIndicator()// 使用默认进度条
                    .setIndicatorColor(Color.TRANSPARENT)
//                    .defaultProgressBarColor() // 使用默认进度条颜色
                    .setReceivedTitleCallback { _, _ -> } //设置 Web 页面的 title 回调
                    .setSecutityType(AgentWeb.SecurityType.strict)
                    .createAgentWeb()
                    .ready()
                    .go(mUrl)
        } else {
            mAgentWeb!!.loader.loadUrl(mUrl)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (!mAgentWeb!!.back()) {
            finish()
        }
    }

}