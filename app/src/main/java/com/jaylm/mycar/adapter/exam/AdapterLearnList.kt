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
class AdapterLearnList : BaseQuickAdapter<LearnListBean, BaseViewHolder>(R.layout.item_learn_list) {

    override fun convert(helper: BaseViewHolder, item: LearnListBean) {
        helper.setText(R.id.tv_sort, String.format("第%s章", helper.adapterPosition + 1))
                .setText(R.id.tv_title, item.chapterName)
                .setText(R.id.tv_num, String.format("共%s节", item.videos.size))
                .setText(R.id.tv_seek, item.playCount)
        ImageUtils.showImage(mContext, item.icon, helper.getView(R.id.iv_logo))
    }
}