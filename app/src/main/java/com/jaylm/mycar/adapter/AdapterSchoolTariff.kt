package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.SchoolTariffBean

/**
 * Created by jaylm
 * on 2018/10/5.
 */
class AdapterSchoolTariff : BaseQuickAdapter<SchoolTariffBean, BaseViewHolder>(R.layout.item_school_info_image) {
    override fun convert(helper: BaseViewHolder?, item: SchoolTariffBean?) {
    }
}