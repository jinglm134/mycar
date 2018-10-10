package com.jaylm.mycar.ui.exam

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaylm.mycar.R
import com.jaylm.mycar.adapter.exam.AdapterLearnDetail
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.exam.LearnListBean
import com.jaylm.mycar.ui.ActivityVideoPlayer
import com.jaylm.mycar.view.DecorationLinearDivider
import kotlinx.android.synthetic.main.layout_recyclerview.*

/**
 * 学车课堂
 * Created by jaylm
 * on 2018/10/10.
 */
class LearnDetailActivity : BaseActivity() {

    private lateinit var mData: List<LearnListBean.VideosBean>
    private lateinit var mAdapter: AdapterLearnDetail
    private lateinit var mTitle: String
    override fun bindLayout(): Int {
        return R.layout.layout_recyclerview
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        val data = bundle.getParcelable("data") as LearnListBean
        mTitle = data.chapterName
        mData = data.videos
    }

    override fun initView() {
        super.initView()
        setHeader(mTitle)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.addItemDecoration(DecorationLinearDivider(R.color.c10, 10F, true))
        mAdapter = AdapterLearnDetail()
        recyclerView.adapter = mAdapter

        mAdapter.setNewData(mData)
    }

    override fun setListener() {
        super.setListener()
        mAdapter.setOnItemClickListener { _, _, position ->
            val bundle = Bundle()
            bundle.putString("url", mData[position].playurl)
            bundle.putString("thumb", mData[position].imageBig)
            bundle.putString("title", mData[position].title)
            startActivity(ActivityVideoPlayer::class.java, bundle)
        }
    }

}