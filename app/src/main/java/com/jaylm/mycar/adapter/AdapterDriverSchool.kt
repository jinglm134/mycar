package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.RecommendMaintainBean
import com.jaylm.mycar.bean.SchoolHotBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/4.
 */
class AdapterDriverSchool : BaseQuickAdapter<SchoolHotBean.ItemsBean, BaseViewHolder>(R.layout.item_driver_school) {
    override fun convert(helper: BaseViewHolder, item: SchoolHotBean.ItemsBean) {
        ImageUtils.showImage(mContext, item.CorpLogo, helper.getView(R.id.iv_logo))
        helper.setText(R.id.tv_name, item.Short_CorpName)
        helper.setText(R.id.tv_location, item.Manage_Addr)
        helper.setText(R.id.tv_discuss, String.format("%s评价", item.CommentCount))
        helper.setText(R.id.tv_price, String.format("¥%s", item.SetPrice))
    }
}