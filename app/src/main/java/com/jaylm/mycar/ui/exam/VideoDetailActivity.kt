package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterKM2Video
import com.jaylm.mycar.adapter.exam.AdapterVideoTitle
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.ExamKM2VideoBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_vedio_base_detail.*
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/12.
 */
class VideoDetailActivity : BaseActivity() {

    private var mBrandId = 1//默认车辆id为1
    private var pageIndex = 1//默认第一页
    private var type = 0//0:考点视频  1：基础操作
    private var channelid = 205//205:科二  206：科三

    private lateinit var mTitleData: ArrayList<ExamKM2VideoBean.CarbrandBean>
    private lateinit var mData: ArrayList<ExamKM2VideoBean.VideosBean>

    private lateinit var mTitleAdapter: AdapterVideoTitle
    private lateinit var mAdapter: AdapterKM2Video

    override fun bindLayout(): Int {
        return R.layout.activity_vedio_base_detail
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        type = bundle.getInt("type", 0)
        channelid = bundle.getInt("channelid", 0)
    }

    override fun initView() {
        super.initView()


        if (type == 1) {
            ll_brand.visibility = View.VISIBLE
            setHeader("基础操作")
        } else {
            setHeader("热点视频")
        }
        mTitleData = ArrayList()
        recyclerView_brand.setHasFixedSize(true)
        recyclerView_brand.layoutManager = LinearLayoutManager(mActivity, LinearLayout.HORIZONTAL, false)
        mTitleAdapter = AdapterVideoTitle()
        recyclerView_brand.adapter = mTitleAdapter

        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterKM2Video()
        recyclerView.adapter = mAdapter

        smartRefreshLayout.autoRefresh()
    }

    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            pageIndex = 1
            loadData(true)
        }
        smartRefreshLayout.setOnLoadMoreListener {
            pageIndex++
            loadData(false)
        }

        mTitleAdapter.setOnItemClickListener { _, _, position ->
            mBrandId = mTitleData[position].brandId
            smartRefreshLayout.autoRefresh()
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putParcelable("data", adapter.data[position] as ExamKM2VideoBean.VideosBean)
            startActivity(VideoPlayActivity::class.java, bundle)
        }
    }

    private fun loadData(isPullDown: Boolean) {
        val callback = object : BaseCallBack(mActivity, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val result = JSONObject(response.body()).optString("result")
                val data = GsonUtils.parseJsonWithGson(result, ExamKM2VideoBean::class.java)

                if (data.carbrand != null) {
                    mTitleData.clear()
                    mTitleData.addAll(data.carbrand)
                    mTitleAdapter.setNewData(mTitleData, mBrandId)
                }

                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(data.videos)
                mAdapter.setNewData(mData)
            }

        }
        if (type == 0) {
            WebList.km2_rd_list(channelid, pageIndex, callback)
        } else {
            WebList.km2_jc_list(channelid, mBrandId, pageIndex, callback)
        }
    }

}