package com.jaylm.mycar.ui.host

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterImageBrand
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.host.ImageBrandBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/18.
 */
class FragmentImageBrand : BaseFragment() {
    private var mId = -1
    private lateinit var mData: ArrayList<ImageBrandBean>
    private lateinit var mAdapter: AdapterImageBrand

    override fun bindLayout(): Int {
        return R.layout.layout_smartrecyclerview
    }

    override fun initView() {
        super.initView()

        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterImageBrand()
        recyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            mId = -1
            loadData(true)
        }
        smartRefreshLayout.setOnLoadMoreListener {
            if (mData.size > 0) {
                mId = mData[mData.size - 1].id
            }
            loadData(false)
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putInt("groupId", (adapter.data[position] as ImageBrandBean).id)
            bundle.putString("name", (adapter.data[position] as ImageBrandBean).name)
            startActivity(ActivityImageBrandDetail::class.java, bundle)
        }

        smartRefreshLayout.autoRefresh()
    }

    private fun loadData(isPullDown: Boolean) {
        WebList.listOrderByUpdateTime(mId, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val data = GsonUtils.parseJsonArrayWithGson(JSONObject(response.body()).optString("result"), ImageBrandBean::class.java)
                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(data)
                mAdapter.setNewData(mData)
            }
        })
    }
}