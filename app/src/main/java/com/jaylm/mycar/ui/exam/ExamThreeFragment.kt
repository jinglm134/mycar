package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterKM2Video
import com.jaylm.mycar.adapter.exam.AdapterNew
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.exam.ExamKM2VideoBean
import com.jaylm.mycar.bean.exam.ExamNewBean
import com.jaylm.mycar.net.API
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.WebViewActivity
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_exam_three.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamThreeFragment : BaseFragment() {

    private val channelid = 206
    private val model = "km3"
    private lateinit var mData: ArrayList<ExamKM2VideoBean.VideosBean>
    private lateinit var mAdapter: AdapterKM2Video
    private lateinit var mData2: ArrayList<ExamNewBean.DataBean>
    private lateinit var mAdapter2: AdapterNew

    override fun bindLayout(): Int {
        return R.layout.fragment_exam_three
    }

    override fun initView() {
        super.initView()
        UShape.setBackgroundDrawable(tv_1, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_2, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_3, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_4, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_5, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))


        mData = ArrayList()
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterKM2Video()
        recyclerView.adapter = mAdapter

        mData2 = ArrayList()
        recyclerView2.isNestedScrollingEnabled = false
        recyclerView2.setHasFixedSize(true)
        recyclerView2.layoutManager = LinearLayoutManager(activity)
        recyclerView2.addItemDecoration(DecorationLinearDivider(R.color.c10, 1F, true))
        mAdapter2 = AdapterNew()
        recyclerView2.adapter = mAdapter2

        smartRefreshLayout.setEnableLoadMore(false)
        loadData()
    }

    override fun setListener() {
        super.setListener()
        tv_1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试规则")
            bundle.putString("url", API.km3_ksgz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试流程")
            bundle.putString("url", API.km3_kslc)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试标准")
            bundle.putString("url", API.km3_hgbz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试要点")
            bundle.putString("url", API.km3_ksyd)
            startActivity(WebViewActivity::class.java, bundle)

        }
        tv_5.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考前冲刺")
            bundle.putString("url", API.jinnang_3)
            startActivity(WebViewActivity::class.java, bundle)
        }

        ll_jclk.setOnClickListener {
            startActivity(ActivityJCLK::class.java)
        }

        ll_zhqb.setOnClickListener {
            startActivity(ActivityZHQB::class.java)
        }

        ll_lkkj.setOnClickListener {
            startActivity(ActivityLKKJ::class.java)
        }

        ll_dtjq.setOnClickListener {
            startActivity(ActivityDTJQ::class.java)
        }

        ll_yk.setOnClickListener {
            startActivity(ActivityYK::class.java)
        }

        tv_more.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("type", 0)
            bundle.putInt("channelid", channelid)
            startActivity(VideoDetailActivity::class.java, bundle)
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putParcelable("data", adapter.data[position] as ExamKM2VideoBean.VideosBean)
            startActivity(VideoPlayActivity::class.java, bundle)
        }

        smartRefreshLayout.setOnRefreshListener {
            loadData()
            loadNewData()
        }

        mAdapter2.setOnItemClickListener { adapter, _, pos ->
            val bundle = Bundle()
            bundle.putString("name", (adapter.data[pos] as ExamNewBean.DataBean).title)
            bundle.putString("url", (adapter.data[pos] as ExamNewBean.DataBean).url)
            startActivity(WebViewActivity::class.java, bundle)
        }

        tv_more2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("model", model)
            startActivity(NewListActivity::class.java, bundle)
        }
    }

    private fun loadData() {
        WebList.km2_rd_index(channelid, object : BaseCallBack(activity!!, smartRefreshLayout) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val result = JSONObject(response.body()).optString("result")
                val data = GsonUtils.parseJsonWithGson(result, ExamKM2VideoBean::class.java)
                mData.clear()
                mData.addAll(data.videos)
                mAdapter.setNewData(mData)
            }

        })

    }

    private fun loadNewData() {
        WebList.toutiao_info(model, 1, 10, object : BaseCallBack(activity!!, smartRefreshLayout) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val data = GsonUtils.parseJsonWithGson(response.body(), ExamNewBean::class.java)
                mData2.clear()
                mData2.addAll(data.data)
                mAdapter2.setNewData(mData2)
            }

        })
    }
}