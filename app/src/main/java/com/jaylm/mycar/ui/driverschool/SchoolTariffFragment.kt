package com.jaylm.mycar.ui.driverschool

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterSchoolTariff
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SchoolTariffBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_recyclerview.*
import org.json.JSONObject

/**
 * 驾校详情-套餐
 * Created by jaylm
 * on 2018/10/5.
 */
class SchoolTariffFragment : BaseFragment() {

    private val mId: String by bindArgument("id")
    private lateinit var mData: ArrayList<SchoolTariffBean>
    private lateinit var mAdapter: AdapterSchoolTariff

    companion object {
        fun newInstance(id: String): SchoolTariffFragment {
            val schoolInfoFragment = SchoolTariffFragment()
            val bundle = Bundle()
            bundle.putString("id", id)
            schoolInfoFragment.arguments = bundle
            return schoolInfoFragment
        }
    }

    override fun bindLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun initView() {
        super.initView()

        mData = ArrayList()
        mAdapter = AdapterSchoolTariff()
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider(R.color.c10, 5F))
        recyclerView.adapter = mAdapter

        loadData()
    }

    override fun setListener() {
        super.setListener()
        mAdapter.setOnItemClickListener { adapter, view, position ->

        }
    }

    private fun loadData() {
        WebList.getCorpSet(mId, object : BaseCallBack(activity!!, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val jsonObject = JSONObject(response.body())
                val data = jsonObject.optString("Data")
                val schoolTariffBean = GsonUtils.parseJsonArrayWithGson(data, SchoolTariffBean::class.java)
                mData.clear()
                mData.addAll(schoolTariffBean)
                mAdapter.setNewData(mData)
            }
        })
    }
}