package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterNew
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.ExamNewBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.ui.WebViewActivity
import com.jaylm.mycar.util.GsonUtils
import com.jaylm.mycar.view.DecorationLinearDivider
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.layout_smartrecyclerview.*

/**
 * Created by jaylm
 * on 2018/10/15.
 */
class NewListActivity : BaseActivity() {
    private lateinit var mData: ArrayList<ExamNewBean.DataBean>
    private lateinit var mAdapter: AdapterNew
    private lateinit var model: String
    private var pageNum = 1
    override fun bindLayout(): Int {
        return R.layout.layout_smartrecyclerview
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        model = bundle.getString("model", "")
    }

    override fun initView() {
        super.initView()
        setHeader("驾考头条")

        mData = ArrayList()
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.addItemDecoration(DecorationLinearDivider())
        mAdapter = AdapterNew()
        recyclerView.adapter = mAdapter
    }

    override fun setListener() {
        super.setListener()
        smartRefreshLayout.setOnRefreshListener {
            pageNum = 1
            loadData(true)
        }
        smartRefreshLayout.setOnLoadMoreListener {
            pageNum++
            loadData(false)
        }

        mAdapter.setOnItemClickListener { adapter, _, pos ->
            val bundle = Bundle()
            bundle.putString("name", (adapter.data[pos] as ExamNewBean.DataBean).title)
            bundle.putString("url", (adapter.data[pos] as ExamNewBean.DataBean).url)
            startActivity(WebViewActivity::class.java, bundle)
        }

        smartRefreshLayout.autoRefresh()
    }

    private fun loadData(isPullDown: Boolean) {
        WebList.toutiao_info(model, pageNum, 20, object : BaseCallBack(mActivity, smartRefreshLayout, isPullDown) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)

                val data = GsonUtils.parseJsonWithGson(response.body(), ExamNewBean::class.java)
                if (isPullDown) {
                    mData.clear()
                }
                mData.addAll(data.data)
                mAdapter.setNewData(mData)
            }

        })
    }
}