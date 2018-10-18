package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.host.ImageBrandBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/16.
 */
class AdapterImageBrand : BaseQuickAdapter<ImageBrandBean, BaseViewHolder>(R.layout.item_image_brand) {

    override fun convert(helper: BaseViewHolder, bean: ImageBrandBean) {
        helper.setText(R.id.tv_title, bean.name)
                .setText(R.id.tv_total, String.format("共%s张图片", bean.picCount))
                .setText(R.id.tv_time,  bean.lastUpdateTimeStr)

        val pic = bean.picSource
        val url = if (!pic.startsWith("http")) {
            String.format("http:%s", pic)
        } else {
            pic
        }
        ImageUtils.showImage(mContext, url, helper.getView(R.id.iv_content))
    }

}