package com.jaylm.mycar.adapter.exam

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.LearnListBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterLearnDetail : BaseQuickAdapter<LearnListBean.VideosBean, BaseViewHolder>(R.layout.item_learn_detail) {

    override fun convert(helper: BaseViewHolder, item: LearnListBean.VideosBean) {
        helper.setText(R.id.tv_sort, String.format("第%s节", helper.adapterPosition + 1))
                .setText(R.id.tv_title, item.title)
                .setText(R.id.tv_time, format(item.duration.toInt()))
                .setText(R.id.tv_like, item.likeNum)
                .setText(R.id.tv_seek, item.view)
        ImageUtils.showImage(mContext, item.imageBig, helper.getView(R.id.iv_video))
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