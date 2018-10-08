package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.SchoolCoachBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/8.
 */
class AdapterSchoolCoach : BaseQuickAdapter<SchoolCoachBean, BaseViewHolder>(R.layout.item_school_coach) {
    override fun convert(helper: BaseViewHolder, item: SchoolCoachBean) {

        helper.setText(R.id.tv_name_gender, String.format("%s (%s)", item.Name, item.Gender))
                .setText(R.id.tv_teach_year, String.format("教龄: %s", item.Teach_Age))
                .setText(R.id.tv_discuss, String.format("%s评论", item.CommentCount))
                .setText(R.id.tv_level, item.Coach_CreditLevel)
                .setRating(R.id.ratingBar, item.AvgScore.toFloat())

        val gender = if ("男" == item.Gender) {
            R.mipmap.icon_header_men
        } else {
            R.mipmap.icon_header_women
        }
        ImageUtils.showImage(mContext, item.CoachPic, helper.getView(R.id.iv_header), gender)
    }
}