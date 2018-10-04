package com.jaylm.mycar.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterRecommendMaintain
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
    private lateinit var mAdapter: AdapterRecommendMaintain

    override fun bindLayout(): Int {
        return R.layout.fragment_maintain
    }

    override fun initView() {
        super.initView()
        mBannerData = ArrayList()
        mRecommendData = ArrayList()
        mAdapter = AdapterRecommendMaintain()

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        smartRefreshLayout.setEnableRefresh(false)
        smartRefreshLayout.setEnableLoadMore(false)

        recyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        //banner点击事件
        banner.setOnBannerListener { position ->
            val url = mBannerData[position].url
            val name = mBannerData[position].name
            val bundle = Bundle()
            bundle.putString("url", url)
            bundle.putString("name", name)
            startActivity(WebViewActivity::class.java, bundle)
        }

        //推荐新闻的点击事件
        mAdapter.setOnItemClickListener { adapter, _, position ->
            val url = (adapter.data[position] as RecommendMaintain).url
            val name = (adapter.data[position] as RecommendMaintain).title
            val bundle = Bundle()
            bundle.putString("url", url)
            bundle.putString("name", name)
            startActivity(WebViewActivity::class.java, bundle)
        }
    }

    //拉取banner数据
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

        //获取推荐数据
        WebList.recommendList(object : BaseCallBack(activity!!) {
            override fun onSuccess(jsonString: String) {
                val data = GsonUtils.parseJsonArrayWithGson(jsonString, RecommendMaintain::class.java)
                mRecommendData.clear()
                mRecommendData.addAll(data)
                mAdapter.setNewData(mRecommendData)
            }

        })
    }


    //绑定banner
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