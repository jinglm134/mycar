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
import com.jaylm.mycar.global.VariableInfo
import com.jaylm.mycar.tool.UCall
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.ui.ActivityVideoPlayer
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.jaylm.mycar.util.StringUtils
import kotlinx.android.synthetic.main.fragment_school_info.*
import kotlinx.android.synthetic.main.layout_recyclerview.*

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

        tv_name.text = mData.LonLatName
        tv_address.text = mData.LonLatAddr
        tv_summary.text = mData.Summary
        UShape.setBackgroundDrawable(tv_contact, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))


        if (StringUtils.isEmpty(mData.VedioUrl)) {
            tv_video.visibility = View.GONE
        } else {
            tv_video.visibility = View.VISIBLE
            UShape.setBackgroundDrawable(tv_video, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        }

        initRecyclerView()

    }

    private fun initRecyclerView() {
        recyclerView_type.setHasFixedSize(true)
        recyclerView_type.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerView_tag.setHasFixedSize(true)
        recyclerView_tag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        recyclerView_img.isNestedScrollingEnabled = false
        recyclerView_img.setHasFixedSize(true)
        recyclerView_img.layoutManager = LinearLayoutManager(activity)
//        recyclerView_img.addItemDecoration(DecorationLinearDivider(R.color.c14), 10)


        recyclerView_type.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_school_info_text, mData.TrainVehicleTypes) {
            override fun convert(helper: BaseViewHolder, item: String?) {
                val view = helper.getView<TextView>(R.id.tv_item)
                UShape.setBackgroundDrawable(view, UShape.getCornerDrawable(UShape.getColor(R.color.c9), 2))
                view.setTextColor(UShape.getColor(R.color.c14))
                view.text = item
            }
        }

        recyclerView_tag.adapter = object : BaseQuickAdapter<SchoolDetailBean.CorpMarksBean, BaseViewHolder>(R.layout.item_school_info_text, mData.CorpMarks) {
            override fun convert(helper: BaseViewHolder, item: SchoolDetailBean.CorpMarksBean) {
                val view = helper.getView<TextView>(R.id.tv_item)
                UShape.setBackgroundDrawable(view, UShape.getStrokeDrawable(Color.parseColor(item.MarkColor), 4))
                view.setTextColor(Color.parseColor(item.MarkColor))
                view.text = item.MarkName
            }
        }

        recyclerView_img.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_school_info_image, mData.EfencePics) {
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
                UCall.dialPhone(activity!!, VariableInfo.customerPhone)
            }
            R.id.tv_video -> {
                val bundle = Bundle()
                bundle.putString("url", mData.VedioUrl)
                bundle.putString("thumb", mData.PicUrl3D)
                bundle.putString("title", mData.Corp_Name)
                startActivity(ActivityVideoPlayer::class.java, bundle)
            }
        }
    }
}