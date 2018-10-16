package com.jaylm.mycar.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterNews
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.NewsBean
import com.jaylm.mycar.bean.SectionNewsBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*

/**
 * Created by jaylm
 * on 2018/10/16.
 */
class FragmentNews : BaseFragment() {

    private var mId: Long = 0
    private val mType: Int by bindArgument("type")

    private lateinit var mData: ArrayList<SectionNewsBean>
    private lateinit var mAdapter: AdapterNews

    override fun bindLayout(): Int {
        return R.layout.layout_smartrecyclerview
    }

    companion object {
        fun newInstance(type: Int): FragmentNews {
            val newsFragment = FragmentNews()
            val bundle = Bundle()
            bundle.putInt("type", type)
            newsFragment.arguments = bundle
            return newsFragment
        }
    }

    override fun initView() {
        super.initView()
        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterNews()
        recyclerView.adapter = mAdapter

        smartRefreshLayout.autoRefresh()
    }


    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            if (mData.size > 0) {
                mId = mData[0].t.hot_at
            }
            loadData(true)
        }
        smartRefreshLayout.setOnLoadMoreListener {
            if (mData.size > 0) {
                mId = mData[mData.size - 1].t.hot_at
            }
            loadData(false)
        }
    }

    private fun loadData(isPullDown: Boolean) {
        WebList.news(mType, isPullDown, mId, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val data = GsonUtils.parseJsonArrayWithGson(response.body(), NewsBean::class.java)

                data.forEach { it ->
                    mData.add(SectionNewsBean(it))
                }

                mAdapter.setNewData(mData)
            }

        })
    }

}