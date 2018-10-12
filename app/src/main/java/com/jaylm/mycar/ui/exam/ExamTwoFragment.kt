package com.jaylm.mycar.ui.exam

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterKM2Video
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.exam.BannerTwoBean
import com.jaylm.mycar.bean.exam.ExamKM2Video
import com.jaylm.mycar.net.API
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.WebViewActivity
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_exam_two.*
import org.json.JSONObject

/**
 * 驾考-科二
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamTwoFragment : BaseFragment() {

    private val carbrand = 1//默认车型
    private val type_jichu = 1//基础操作
    private val type_kaodian = 0//考点视频

    private lateinit var mBannerData: ArrayList<BannerTwoBean>
    private lateinit var mData1: ArrayList<ExamKM2Video.VideosBean>
    private lateinit var mData2: ArrayList<ExamKM2Video.VideosBean>
    private lateinit var mAdapter1: AdapterKM2Video
    private lateinit var mAdapter2: AdapterKM2Video
    override fun bindLayout(): Int {
        return R.layout.fragment_exam_two
    }

    override fun initView() {
        super.initView()
        mBannerData = ArrayList()
        UShape.setBackgroundDrawable(tv_1, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_2, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_3, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_4, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_5, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))

        mData1 = ArrayList()
        recyclerView1.isNestedScrollingEnabled = false
        recyclerView1.setHasFixedSize(true)
        recyclerView1.layoutManager = LinearLayoutManager(activity)
        recyclerView1.addItemDecoration(DecorationLinearDivider())
        mAdapter1 = AdapterKM2Video()
        recyclerView1.adapter = mAdapter1

        mData2 = ArrayList()
        recyclerView2.isNestedScrollingEnabled = false
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(activity)
        recyclerView2.addItemDecoration(DecorationLinearDivider())
        mAdapter2 = AdapterKM2Video()
        recyclerView2.adapter = mAdapter2

        loadBannerData()
        loadVideoData()
    }

    override fun setListener() {
        super.setListener()
        tv_1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试规则")
            bundle.putString("url", API.km2_ksgz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试流程")
            bundle.putString("url", API.km2_kslc)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试标准")
            bundle.putString("url", API.km2_hgbz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试要点")
            bundle.putString("url", API.km2_ksyd)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_5.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考前冲刺")
            bundle.putString("url", API.jinnang_2)
            startActivity(WebViewActivity::class.java, bundle)
        }

        banner.setOnBannerListener { position ->
            val bundle = Bundle()
            bundle.putString("name", mBannerData[position].title)
            bundle.putString("url", mBannerData[position].url)
            startActivity(WebViewActivity::class.java, bundle)

        }

        tv_more1.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("type", type_jichu)
            startActivity(VideoBaseDetailActivity::class.java, bundle)
        }
        tv_more2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("type", type_kaodian)
            startActivity(VideoBaseDetailActivity::class.java, bundle)
        }
    }

    private fun loadBannerData() {
        WebList.appBanner(object : BaseCallBack(activity!!, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val jsonString = JSONObject(response.body()).optString("data")
                val data = GsonUtils.parseJsonArrayWithGson(jsonString, BannerTwoBean::class.java)
                mBannerData.clear()
                mBannerData.addAll(data)

                bindBanner()
            }
        })


    }

    private fun loadVideoData() {
        WebList.km2_jc_index(carbrand, object : BaseCallBack(activity!!) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val result = JSONObject(response.body()).optString("result")
                val data = GsonUtils.parseJsonWithGson(result, ExamKM2Video::class.java)
                mData1.clear()
                mData1.addAll(data.videos)
                mAdapter1.setNewData(mData1)
            }

        })


        WebList.km2_rd_index(object : BaseCallBack(activity!!) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val result = JSONObject(response.body()).optString("result")
                val data = GsonUtils.parseJsonWithGson(result, ExamKM2Video::class.java)
                mData2.clear()
                mData2.addAll(data.videos)
                mAdapter2.setNewData(mData2)
            }

        })
    }

    private fun bindBanner() {
        val imageList = ArrayList<String>()
        for (i in mBannerData.indices) {
            imageList.add(mBannerData[i].pic)
        }

        banner.setImages(imageList).setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any, imageView: ImageView?) {
                ImageUtils.showImage(context, path.toString(), imageView)
            }
        })
                .setDelayTime(5000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setIndicatorGravity(BannerConfig.RIGHT)//指示器居右
                .setBannerAnimation(Transformer.Stack)
                .start()
    }
}