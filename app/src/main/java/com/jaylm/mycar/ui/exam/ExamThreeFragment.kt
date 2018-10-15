package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterKM2Video
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.exam.ExamKM2Video
import com.jaylm.mycar.net.API
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.WebViewActivity
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_exam_three.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamThreeFragment : BaseFragment() {

    private val channelid = 206
    private lateinit var mData: ArrayList<ExamKM2Video.VideosBean>
    private lateinit var mAdapter: AdapterKM2Video

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
            bundle.putParcelable("data", adapter.data[position] as ExamKM2Video.VideosBean)
            startActivity(VideoPlayActivity::class.java, bundle)
        }

    }

    private fun loadData() {
        WebList.km2_rd_index(channelid, object : BaseCallBack(activity!!,true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val result = JSONObject(response.body()).optString("result")
                val data = GsonUtils.parseJsonWithGson(result, ExamKM2Video::class.java)
                mData.clear()
                mData.addAll(data.videos)
                mAdapter.setNewData(mData)
            }

        })
    }
}