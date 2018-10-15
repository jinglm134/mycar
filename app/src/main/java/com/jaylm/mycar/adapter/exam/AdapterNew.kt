package com.jaylm.mycar.adapter.exam

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.ExamNewBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterNew : BaseQuickAdapter<ExamNewBean.DataBean, BaseViewHolder>(R.layout.item_new) {

    override fun convert(helper: BaseViewHolder, item: ExamNewBean.DataBean) {
        helper.setText(R.id.tv_name, item.title)
                .setText(R.id.tv_time, item.viewdt)
                .setText(R.id.tv_name, item.title)
        ImageUtils.showImage(mContext, item.img, helper.getView(R.id.iv_new))
    }

}