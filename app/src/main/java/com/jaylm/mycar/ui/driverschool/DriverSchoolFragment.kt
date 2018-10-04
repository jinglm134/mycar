package com.jaylm.mycar.ui.driverschool

import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.AdapterDriverSchool
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SchoolHotBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_driver_school.*
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*
import org.json.JSONObject

/**
 * 驾校
 * Created by jaylm
 * on 2018/10/4.
 */
class DriverSchoolFragment : BaseFragment() {

    private lateinit var mData: ArrayList<SchoolHotBean.ItemsBean>
    private lateinit var mAdapter: AdapterDriverSchool
    private var pageIndex = 1
    override fun bindLayout(): Int {
        return R.layout.fragment_driver_school
    }

    override fun initView() {
        super.initView()

        tabLayout.addTab(tabLayout.newTab().setText("综合排序"))
        tabLayout.addTab(tabLayout.newTab().setText("距离最近"))
        tabLayout.addTab(tabLayout.newTab().setText("评分有先"))
        tabLayout.addTab(tabLayout.newTab().setText("区域"))

        mData = ArrayList()
        mAdapter = AdapterDriverSchool()

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        recyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            pageIndex = 1
            loadData()
        }
        smartRefreshLayout.setOnLoadMoreListener {
            pageIndex++
            loadData(false)
        }
    }

    private fun loadData(isPullDown: Boolean = true) {
        WebList.schoolHot(pageIndex, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val jsonObject = JSONObject(response.body())
                /*JsonObject.opt 无key值时会得到默认值,JsonObject.get无key值会出错*/
                val data = jsonObject.optString("Data")
                val schoolHotBean = GsonUtils.parseJsonWithGson(data, SchoolHotBean::class.java)
                val itemBean = schoolHotBean.Items
                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(itemBean)
                mAdapter.setNewData(mData)

            }

        })
    }

    override fun onStart() {
        super.onStart()
        smartRefreshLayout.autoRefresh()
    }
}