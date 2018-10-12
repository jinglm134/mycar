package com.jaylm.mycar.adapter.exam

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.ExamKM2Video
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.jaylm.mycar.util.StringUtils

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterKM2Video : BaseQuickAdapter<ExamKM2Video.VideosBean, BaseViewHolder>(R.layout.item_km2_video) {

    override fun convert(helper: BaseViewHolder, item: ExamKM2Video.VideosBean) {
        helper.setText(R.id.tv_xingui, item.label)
                .setText(R.id.tv_time, format(item.duration.toInt()))
                .setText(R.id.tv_title, item.title)
                .setText(R.id.tv_passrate, item.passrate)
                .setText(R.id.tv_content, item.summary)
                .setText(R.id.tv_like, item.likeNum)
                .setText(R.id.tv_seek, item.view)
        ImageUtils.showImage(mContext, item.imagePc, helper.getView(R.id.iv_pic))

//        if (!StringUtils.isEmpty(item.label)) {
//            UShape.setBackgroundDrawable(helper.getView(R.id.tv_xingui), UShape.getCornerDrawable(UShape.getColor(R.color.colorPrimary), 2))
//        }
    }

    private fun format(s: Int): String {
        var hour = 0
        var minite = 0
        val second: Int
        if (s >= 60) {
            second = s % 60
            val m = s / 60
            if (m >= 60) {
                minite = m % 60
                hour = m / 60
            } else {
                minite = m
            }
        } else {
            second = s
        }


        return if (hour == 0) {
            String.format("%s:%s", minite, second)
        } else {
            String.format("%s:%s:%s", hour, minite, second)
        }
    }
}