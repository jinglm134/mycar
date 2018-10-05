package com.jaylm.mycar.ui.driverschool

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
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
    private var mPageIndex = 1
    private var mFilterType = 0
    override fun bindLayout(): Int {
        return R.layout.fragment_driver_school
    }

    override fun initView() {
        super.initView()

        tabLayout.addTab(tabLayout.newTab().setText("综合排序"))
        tabLayout.addTab(tabLayout.newTab().setText("距离最近"))
        tabLayout.addTab(tabLayout.newTab().setText("评分优先"))
        tabLayout.addTab(tabLayout.newTab().setText("区域"))

        mData = ArrayList()
        mAdapter = AdapterDriverSchool()

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        recyclerView.adapter = mAdapter

        smartRefreshLayout.autoRefresh()
    }

    override fun setListener() {
        super.setListener()
        //下拉刷新箭头
        smartRefreshLayout.setOnRefreshListener {
            mPageIndex = 1
            loadData()
        }
        //上拉加载监听
        smartRefreshLayout.setOnLoadMoreListener {
            mPageIndex++
            loadData(false)
        }

        //tabLayout点击事件
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab) {
                //切换赛选条件
                mPageIndex = 1
                mFilterType = tab.position
                smartRefreshLayout.autoRefresh()
            }
        })

        //recyclerView点击事件
        mAdapter.setOnItemClickListener { adapter, _, position ->
            val id = (adapter.data[position] as SchoolHotBean.ItemsBean).Corp_Id
            val bundle = Bundle()
            bundle.putString("corpId", id)
            startActivity(DriverSchoolDetailActivity::class.java, bundle)
        }
    }

    private fun loadData(isPullDown: Boolean = true) {
        WebList.schoolHot(mFilterType, mPageIndex, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val jsonObject = JSONObject(response.body())
                /*JsonObject.opt 无key值时会得到默认值,JsonObject.get无key值会出错*/
                val data = jsonObject.optString("Data") ?: return
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
}