package com.jaylm.mycar.ui.school

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.school.AdapterSchoolCoach
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SchoolCoachBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_recyclerview.*
import org.json.JSONObject

/**
 * 驾校详情-教练
 * Created by jaylm
 * on 2018/10/5.
 */
class SchoolCoachFragment : BaseFragment() {

    private val mId: String by bindArgument("id")
    private lateinit var mData: ArrayList<SchoolCoachBean>
    private lateinit var mAdapter: AdapterSchoolCoach


    companion object {
        fun newInstance(id: String): SchoolCoachFragment {
            val schoolCoachFragment = SchoolCoachFragment()
            val bundle = Bundle()
            bundle.putString("id", id)
            schoolCoachFragment.arguments = bundle
            return schoolCoachFragment
        }
    }

    override fun bindLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun initView() {
        super.initView()
        tv_nodota.text = "暂无教练"
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DecorationLinearDivider(R.color.c10, 1F))


        mData = ArrayList()
        mAdapter = AdapterSchoolCoach()
        mAdapter.bindToRecyclerView(recyclerView)
        recyclerView.adapter = mAdapter

        loadData()
    }

    private fun loadData() {
        WebList.CorpCoachsInfo(mId, object : BaseCallBack(activity!!, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val jsonObject = JSONObject(response.body())
                val data = jsonObject.optString("Data")
                val schoolCoachBean = GsonUtils.parseJsonArrayWithGson(JSONObject(data).optString("Items"), SchoolCoachBean::class.java)

                mData.clear()
                mData.addAll(schoolCoachBean)
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