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
import com.zzhoujay.richtext.ImageHolder
import com.zzhoujay.richtext.RichText
import com.zzhoujay.richtext.callback.ImageFixCallback
import kotlinx.android.synthetic.main.activity_news_detail.*
import java.lang.Exception
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
        if (mData.img != null) {
            for (i in mData.img.indices) {
                val matcher = Pattern.compile("(<!--IMG#)[0-9]*(-->)").matcher(htmlText)
                if (matcher.find()) {
                    htmlText = matcher.replaceFirst("<img src=" + mData.img[i].src + " />")
                } else {
                    break
                }
            }
        }

        RichText.from(htmlText)
                .autoFix(false)
                .fix(object :ImageFixCallback{
                    override fun onInit(holder: ImageHolder?) {
                    }

                    override fun onFailure(holder: ImageHolder?, e: Exception?) {
                    }

                    override fun onLoading(holder: ImageHolder?) {
                    }

                    override fun onSizeReady(holder: ImageHolder?, imageWidth: Int, imageHeight: Int, sizeHolder: ImageHolder.SizeHolder) {
                        sizeHolder.setSize(1000,1000)
                    }

                    override fun onImageReady(holder: ImageHolder?, width: Int, height: Int) {
                    }

                })
//                .imageGetter(object :Image)
//                .size(600,400)
                .into(tv_content)
    }

}