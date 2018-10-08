package com.jaylm.mycar.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.MultiSchoolTariffBean
import com.jaylm.mycar.bean.SchoolTariffBean
import com.jaylm.mycar.tool.UShape

/**
 * Created by jaylm
 * on 2018/10/8.
 */
class AdapterMultiSchoolTariff(val data: ArrayList<MultiItemEntity>) : BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>(data) {

    companion object {
        const val TYPE_0 = 0
        const val TYPE_1 = 1
    }

    init {
        addItemType(TYPE_0, R.layout.item_school_tariff_title)
        addItemType(TYPE_1, R.layout.item_school_tariff_content)
    }


    override fun convert(helper: BaseViewHolder, item: MultiItemEntity) {
        when (helper.itemViewType) {
            TYPE_0 -> {
                val data: MultiSchoolTariffBean = item as MultiSchoolTariffBean
                helper.itemView.setOnClickListener {
                    val position = helper.adapterPosition
                    if (data.isExpanded) {
                        collapse(position)
                    } else {
                        expand(position)
                    }
                }

                helper.setText(R.id.tv_name, data.SetName)
                helper.setText(R.id.tv_price_now, String.format("¥%s", data.InfactPay))
                helper.setText(R.id.tv_C1_C2, data.VehicleType)
                helper.setText(R.id.tv_taocan, "培训套餐")
                helper.setText(R.id.tv_price_old, String.format("原价¥%s", data.TotalPay))
                helper.setImageResource(R.id.iv_arrow, if (data.isExpanded) R.mipmap.arrow_up else R.mipmap.arrow_down)

                UShape.setBackgroundDrawable(helper.getView(R.id.tv_C1_C2), UShape.getCornerDrawable(UShape.getColor(R.color.c9), 4))
                UShape.setBackgroundDrawable(helper.getView(R.id.tv_taocan), UShape.getStrokeDrawable(UShape.getColor(R.color.colorPrimary), 4))
            }

            TYPE_1 -> {
                val data = item as SchoolTariffBean
                helper.setText(R.id.tv_type, data.VehicleType)
                helper.setText(R.id.tv_car, data.VehicleBrand)
                helper.setText(R.id.tv_use_time, String.format("科目二%s小时 科目三%s小时", data.Subject2Hour / 60, data.Subject3Hour / 60))
                helper.setText(R.id.tv_meet_type, data.Pickup)
                helper.setText(R.id.tv_study_type, data.Practicetype)
                helper.setText(R.id.tv_study_time, data.PracticeHour)
                helper.setText(R.id.tv_card_time, data.TakeCardDate)
                helper.setText(R.id.tv_tariff_detail, data.SetDescription)
            }
        }
    }

}