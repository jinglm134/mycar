package com.jaylm.mycar.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.BannerMaintain
import com.jaylm.mycar.bean.RecommendMaintain
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_maintain.*
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*

/**
 * 保养页面
 * Created by jaylm
 * on 2018/10/3.
 */
class MaintainFragment : BaseFragment() {
    private lateinit var mBannerData: ArrayList<BannerMaintain>
    private lateinit var mRecommendData: ArrayList<RecommendMaintain>

    override fun bindLayout(): Int {
        return R.layout.fragment_maintain
    }

    override fun initView() {
        super.initView()
        mBannerData = ArrayList()
        mRecommendData = ArrayList()

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
    }

    override fun setListener() {
        super.setListener()
        banner.setOnBannerListener { position ->
            val url = mBannerData[position].url
            val bundle = Bundle()
            bundle.putString("url", url)
            startActivity(WebViewActivity::class.java, bundle)
        }
    }

    override fun loadData() {
        WebList.bannerMaintain(object : BaseCallBack(activity!!, true) {
            override fun onSuccess(jsonString: String) {
                val data = GsonUtils.parseJsonArrayWithGson(jsonString, BannerMaintain::class.java)
                mBannerData.clear()
                mBannerData.addAll(data)
                if (mBannerData.size > 0) {
                    bindBanner()
                }
            }

        })

        WebList.recommendList(object : BaseCallBack(activity!!, false) {
            override fun onSuccess(jsonString: String) {
                val data = GsonUtils.parseJsonArrayWithGson(jsonString, RecommendMaintain::class.java)
                mRecommendData.clear()
                mRecommendData.addAll(data)
            }

        })
    }

    fun bindBanner() {
        val imageList = ArrayList<String>()
        for (i in 0 until mBannerData.size) {
            imageList.add(mBannerData[i].img)
        }

        banner.setImages(imageList).setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any, imageView: ImageView?) {
                ImageUtils.showImage(activity, path.toString(), imageView)
            }
        })
                .setDelayTime(5000)
//                .setBannerStyle(BannerConfig.RIGHT)
//                .setBannerAnimation(Transformer.DepthPage)
                .start()
    }

}