package com.jaylm.mycar.bean

import com.chad.library.adapter.base.entity.AbstractExpandableItem
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.jaylm.mycar.adapter.AdapterMultiSchoolTariff

/**
 * Created by jaylm
 * on 2018/10/8.
 */
class MultiSchoolTariffBean(val SetName: String, val InfactPay: Double, val VehicleType: String, val TotalPay: Double) : AbstractExpandableItem<SchoolTariffBean>(), MultiItemEntity {
    override fun getItemType(): Int {
        return AdapterMultiSchoolTariff.TYPE_0
    }

    override fun getLevel(): Int {
        return 0
    }
}