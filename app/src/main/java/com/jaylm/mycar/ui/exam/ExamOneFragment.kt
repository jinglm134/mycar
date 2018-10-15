package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterExamCheat
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.exam.ExamCheatBean
import com.jaylm.mycar.net.API
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.ui.HideWebViewActivity
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.fragment_exam_one.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamOneFragment : BaseFragment() {

    private var mPage = 1
    private lateinit var mData: ArrayList<ExamCheatBean>
    private lateinit var mAdapter: AdapterExamCheat

    override fun bindLayout(): Int {
        return R.layout.fragment_exam_one
    }

    override fun initView() {
        super.initView()

        mData = ArrayList()
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterExamCheat()
        recyclerView.adapter = mAdapter

        smartRefreshLayout.autoRefresh()
    }

    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnLoadMoreListener {
            mPage++
            loadData(false)
        }
        smartRefreshLayout.setOnRefreshListener {
            mPage = 1
            loadData(true)
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            val bundle = Bundle()
            bundle.putString("url", (adapter.data[position] as ExamCheatBean).useraction.url)
            bundle.putLong("id", (adapter.data[position] as ExamCheatBean).articleId)
            startActivity(ExamCheatDetailActivity::class.java, bundle)
        }

        ll_1.setOnClickListener {
            startActivity(LearnListActivity::class.java)
        }

        ll_2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url", API.info_5)
            bundle.putString("name", "交通标志")
            startActivity(HideWebViewActivity::class.java, bundle)
        }
        ll_3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url", API.list_664)
            bundle.putString("name", "仪表指示灯")
            startActivity(HideWebViewActivity::class.java, bundle)
        }
        ll_4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url", API.list_665)
            bundle.putString("name", "交警手势")
            startActivity(HideWebViewActivity::class.java, bundle)
        }

        ll_5.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url", API.list_666)
            bundle.putString("name", "车内中控")
            startActivity(HideWebViewActivity::class.java, bundle)
        }
        ll_6.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("url", API.list_726)
            bundle.putString("name", "色盲测试")
            startActivity(HideWebViewActivity::class.java, bundle)
        }
    }

    private fun loadData(isPullDown: Boolean) {
        WebList.Onearticles(mPage, object : BaseCallBack(activity!!, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val result = JSONObject(response.body()).optString("result")
                val list = JSONObject(result).optString("list")
                val articles = JSONObject(list).optString("articles")

                val data = GsonUtils.parseJsonArrayWithGson(articles, ExamCheatBean::class.java)
                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(data)
                mAdapter.setNewData(mData)
            }

        })
    }
}