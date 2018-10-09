package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.SchoolAssessBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/8.
 */
class AdapterSchoolAssess : BaseQuickAdapter<SchoolAssessBean, BaseViewHolder>(R.layout.item_school_assess) {
    override fun convert(helper: BaseViewHolder, item: SchoolAssessBean) {

        helper.setText(R.id.tv_name_gender, String.format("%s (%s)", item.Name, item.Gender))
                .setText(R.id.tv_content, String.format("评论: %s", item.CommentText))
                .setText(R.id.tv_time, item.CommentTime)
                .setRating(R.id.ratingBar, item.Score.toFloat())

        val gender = if ("男" == item.Gender) {
            R.mipmap.icon_header_men
        } else {
            R.mipmap.icon_header_women
        }
        ImageUtils.showImage(mContext, item.TraineePic, helper.getView(R.id.iv_header), gender)
    }
}