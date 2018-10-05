package com.jaylm.mycar.ui.driverschool

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.SchoolDetailBean
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.ui.release.util.ImageUtils
import kotlinx.android.synthetic.main.fragment_school_info.*

/**
 * 驾校详情-简介
 * Created by jaylm
 * on 2018/10/5.
 */
class SchoolInfoFragment : BaseFragment(), View.OnClickListener {


    private val mData: SchoolDetailBean by bindArgument("data")

    companion object {
        fun newInstance(data: SchoolDetailBean): SchoolInfoFragment {
            val schoolInfoFragment = SchoolInfoFragment()
            val bundle = Bundle()
            bundle.putParcelable("data", data)
            schoolInfoFragment.arguments = bundle
            return schoolInfoFragment
        }
    }


    override fun bindLayout(): Int {
        return R.layout.fragment_school_info
    }


    override fun initView() {
        super.initView()

        tv_name.text = mData.lonLatName
        tv_address.text = mData.lonLatAddr
        tv_summary.text = mData.summary
        UShape.setBackgroundDrawable(tv_contact, UShape.getCornerDrawable(UShape.getColor(R.color.colorPrimary), 6))
        UShape.setBackgroundDrawable(tv_video, UShape.getCornerDrawable(UShape.getColor(R.color.colorPrimary), 6))

        initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView_type.setHasFixedSize(true)
        recyclerView_type.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerView_tag.setHasFixedSize(true)
        recyclerView_tag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerView_img.isNestedScrollingEnabled=false
        recyclerView_img.setHasFixedSize(true)
        recyclerView_img.layoutManager = LinearLayoutManager(activity)
//        recyclerView_img.addItemDecoration(DecorationLinearDivider(R.color.c14), 10)


        recyclerView_type.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_school_info_text, mData.trainVehicleTypes) {
            override fun convert(helper: BaseViewHolder, item: String?) {
                val view = helper.getView<TextView>(R.id.tv_item)
                UShape.setBackgroundDrawable(view, UShape.getCornerDrawable(UShape.getColor(R.color.c9), 2))
                view.setTextColor(UShape.getColor(R.color.c14))
                view.text = item
            }
        }

        recyclerView_tag.adapter = object : BaseQuickAdapter<SchoolDetailBean.CorpMarksBean, BaseViewHolder>(R.layout.item_school_info_text, mData.corpMarks) {
            override fun convert(helper: BaseViewHolder, item: SchoolDetailBean.CorpMarksBean) {
                val view = helper.getView<TextView>(R.id.tv_item)
                UShape.setBackgroundDrawable(view, UShape.getStrokeDrawable(Color.parseColor(item.markColor), 4))
                view.setTextColor(Color.parseColor(item.markColor))
                view.text = item.markName
            }
        }

        recyclerView_img.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_school_info_image, mData.efencePics) {
            override fun convert(helper: BaseViewHolder, item: String) {
                ImageUtils.showImage(mContext, item, helper.getView(R.id.iv_item))
            }
        }
    }

    override fun setListener() {
        super.setListener()
        tv_contact.setOnClickListener(this)
        tv_video.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_contact -> {
            }
            R.id.tv_video -> {
            }
        }
    }
}