package com.jaylm.mycar.ui.school

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.school.AdapterSchoolAssess
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SchoolAssessBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_recyclerview.*
import org.json.JSONObject

/**
 * 驾校详情-评价
 * Created by jaylm
 * on 2018/10/5.
 */
class SchoolAssessFragment : BaseFragment() {

    private val mId: String by bindArgument("id")
    private lateinit var mData: ArrayList<SchoolAssessBean>
    private lateinit var mAdapter: AdapterSchoolAssess


    companion object {
        fun newInstance(id: String): SchoolAssessFragment {
            val schoolAssessFragment = SchoolAssessFragment()
            val bundle = Bundle()
            bundle.putString("id", id)
            schoolAssessFragment.arguments = bundle
            return schoolAssessFragment
        }
    }

    override fun bindLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun initView() {
        super.initView()
        tv_nodota.text = "暂无评价"
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DecorationLinearDivider(R.color.c10, 1F))


        mData = ArrayList()
        mAdapter = AdapterSchoolAssess()
        mAdapter.bindToRecyclerView(recyclerView)
        recyclerView.adapter = mAdapter

        loadData()
    }

    private fun loadData() {
        WebList.CommentInfo(mId, object : BaseCallBack(activity!!, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val jsonObject = JSONObject(response.body())
                val data = jsonObject.optString("Data")
                val schoolAssessBean = GsonUtils.parseJsonArrayWithGson(JSONObject(data).optString("Items"), SchoolAssessBean::class.java)

                mData.clear()
                mData.addAll(schoolAssessBean)
                if (mData.size <= 1) {
                    tv_nodota.visibility = View.VISIBLE
                } else {
                    tv_nodota.visibility = View.GONE
                }
                mAdapter.setNewData(mData)
            }

        })
    }
}