package com.jaylm.mycar.ui.host

import android.os.Bundle
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.host.NewsDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.util.TimeUtils
import com.lzy.okgo.model.Response
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.activity_vedio_base_detail.*
import java.util.regex.Pattern

/**
 * Created by jaylm
 * on 2018/10/17.
 */
class ActivityNewsDetail : BaseActivity() {

    private lateinit var mData: NewsDetailBean
    private var id = 0
    override fun bindLayout(): Int {
        return R.layout.activity_news_detail
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        id = bundle.getInt("id", 0)
    }

    override fun initView() {
        super.initView()
        setHeader("详情")

        loadData()
    }

    private fun loadData() {
        WebList.newsDetail(id, object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                mData = GsonUtils.parseJsonWithGson(response.body(), NewsDetailBean::class.java)
                invalidateView()
            }

        })
    }

    private fun invalidateView() {
        tv_title.text = mData.title
        tv_source.text = mData.author
        tv_time.text = TimeUtils.millis2String(mData.published_at)


        var htmlText = mData.content
        for (i in mData.img.indices) {
            val matcher = Pattern.compile("(<!--IMG#)[0-9]*(-->)").matcher(htmlText)
            if (matcher.find()) {
                htmlText = matcher.replaceFirst("<img src=" + mData.img[i].src + " />")
            } else {
                break
            }
        }

        RichText.from(htmlText).into(tv_content)
    }

}