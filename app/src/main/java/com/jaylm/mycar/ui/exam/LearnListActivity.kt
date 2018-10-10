package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterLearnList
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.LearnListBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_recyclerview.*
import org.json.JSONObject

/**
 * 学车课堂
 * Created by jaylm
 * on 2018/10/10.
 */
class LearnListActivity : BaseActivity() {
    private lateinit var mData: ArrayList<LearnListBean>
    private lateinit var mAdapter: AdapterLearnList
    override fun bindLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun initView() {
        super.initView()
        setHeader("学车课堂")

        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.addItemDecoration(DecorationLinearDivider(R.color.c10, 10F, true))
        mAdapter = AdapterLearnList()
        recyclerView.adapter = mAdapter

        loadData()
    }

    override fun setListener() {
        super.setListener()
        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putParcelable("data", adapter.data[position] as LearnListBean)
            mActivity.startActivity(LearnDetailActivity::class.java, bundle)
        }
    }

    private fun loadData() {
        WebList.videoClass(object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val result = JSONObject(response.body()).optString("result")
                val videoClass = JSONObject(result).optString("videoClass")
                val data = GsonUtils.parseJsonArrayWithGson(videoClass, LearnListBean::class.java)
                mData.clear()
                mData.addAll(data)
                mAdapter.setNewData(mData)
            }

        })
    }
}