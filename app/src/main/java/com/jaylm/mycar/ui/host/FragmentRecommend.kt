package com.jaylm.mycar.ui.host

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterNews
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SectionNewsBean
import com.jaylm.mycar.bean.host.NewsBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/16.
 */
class FragmentRecommend : BaseFragment() {

    private var page: Int = 0

    private lateinit var mData: ArrayList<SectionNewsBean>
    private lateinit var mAdapter: AdapterNews

    override fun bindLayout(): Int {
        return R.layout.layout_smartrecyclerview
    }


    override fun initView() {
        super.initView()
        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterNews()
        recyclerView.adapter = mAdapter
    }


    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            page++
            loadData(true)
        }
        smartRefreshLayout.setOnLoadMoreListener {
            page++
            loadData(false)
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putInt("id", (adapter.data[position] as SectionNewsBean).t.item_id)
            startActivity(ActivityNewsDetail::class.java, bundle)
        }

        smartRefreshLayout.autoRefresh()
    }

    private fun loadData(isPullDown: Boolean) {
        WebList.recommend(page, isPullDown, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val data = GsonUtils.parseJsonArrayWithGson(JSONObject(response.body()).optString("data"), NewsBean::class.java)

                data.forEach { it ->
                    mData.add(SectionNewsBean(it))
                }

                mAdapter.setNewData(mData)
            }

        })
    }

}