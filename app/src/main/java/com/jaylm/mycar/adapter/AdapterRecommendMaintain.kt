package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.RecommendMaintain
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/3.
 */
class AdapterRecommendMaintain : BaseQuickAdapter<RecommendMaintain, BaseViewHolder>(R.layout.item_recommend_miantain) {
    override fun convert(helper: BaseViewHolder, item: RecommendMaintain) {
        helper.setText(R.id.tv_title, item.title)
        helper.setText(R.id.tv_content, item.content)
        ImageUtils.showImage(mContext, item.image, helper.getView(R.id.iv_pic))
    }
}