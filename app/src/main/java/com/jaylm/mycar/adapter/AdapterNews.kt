package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.SectionNewsBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/16.
 */
class AdapterNews : BaseSectionQuickAdapter<SectionNewsBean, BaseViewHolder>(R.layout.item_news_three, R.layout.item_news_normal, null) {


    override fun convertHead(helper: BaseViewHolder, bean: SectionNewsBean) {
        val item = bean.t
        helper.setText(R.id.tv_title_single, item.title)
                .setText(R.id.tv_source_single, item.media_name)
        if (item.images != null && item.images.size > 0)
            ImageUtils.showImage(mContext, item.images[0].src, helper.getView(R.id.iv_single))
    }

    override fun convert(helper: BaseViewHolder, bean: SectionNewsBean) {
        val item = bean.t
        helper.setText(R.id.tv_title_multi, item.title)
                .setText(R.id.tv_source_multi, item.media_name)
        if (item.images != null && item.images.size > 0)
            ImageUtils.showImage(mContext, item.images[0].src, helper.getView(R.id.iv_multi1))
        if (item.images != null && item.images.size > 1)
            ImageUtils.showImage(mContext, item.images[1].src, helper.getView(R.id.iv_multi2))
        if (item.images != null && item.images.size > 2)
            ImageUtils.showImage(mContext, item.images[2].src, helper.getView(R.id.iv_multi3))
    }

}