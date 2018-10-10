package com.jaylm.mycar.adapter.school

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.SchoolTariffBean
import com.jaylm.mycar.tool.UShape

/**
 * Created by jaylm
 * on 2018/10/9.
 */
class AdapterSchoolTariff : BaseQuickAdapter<SchoolTariffBean, BaseViewHolder>(R.layout.item_school_tariff) {

    private var expandPosition = -1
    override fun convert(helper: BaseViewHolder, item: SchoolTariffBean) {
        helper.setText(R.id.tv_name, item.SetName)
        helper.setText(R.id.tv_price_now, String.format("¥%s", item.InfactPay))
        helper.setText(R.id.tv_C1_C2, item.VehicleType)
        helper.setText(R.id.tv_taocan, "培训套餐")
        helper.setText(R.id.tv_price_old, String.format("原价¥%s", item.TotalPay))

        UShape.setBackgroundDrawable(helper.getView(R.id.tv_C1_C2), UShape.getCornerDrawable(UShape.getColor(R.color.c9), 4))
        UShape.setBackgroundDrawable(helper.getView(R.id.tv_taocan), UShape.getStrokeDrawable(UShape.getColor(R.color.colorPrimary), 4))

        helper.setText(R.id.tv_type, item.VehicleType)
        helper.setText(R.id.tv_car, item.VehicleBrand)
        helper.setText(R.id.tv_use_time, String.format("科目二%s小时 科目三%s小时", item.Subject2Hour / 60, item.Subject3Hour / 60))
        helper.setText(R.id.tv_meet_type, item.Pickup)
        helper.setText(R.id.tv_study_type, item.Practicetype)
        helper.setText(R.id.tv_study_time, item.PracticeHour)
        helper.setText(R.id.tv_card_time, item.TakeCardDate)
        helper.setText(R.id.tv_tariff_detail, item.SetDescription)

        val llTitle = helper.getView<View>(R.id.ll_title)
        val llContent = helper.getView<View>(R.id.ll_content)

//        llTitle.setOnClickListener {
//            if (llContent.visibility == View.VISIBLE) {
//                llContent.visibility = View.GONE
//                helper.setImageResource(R.id.iv_arrow, R.mipmap.arrow_down)
//            } else {
//                llContent.visibility = View.VISIBLE
//                helper.setImageResource(R.id.iv_arrow, R.mipmap.arrow_up)
//            }
//        }

        if (expandPosition == helper.adapterPosition) {
            llContent.visibility = View.VISIBLE
            helper.setImageResource(R.id.iv_arrow, R.mipmap.arrow_up)
        } else {
            llContent.visibility = View.GONE
            helper.setImageResource(R.id.iv_arrow, R.mipmap.arrow_down)
        }
        llTitle.setOnClickListener {
            togglePosition(helper.adapterPosition)
        }

    }

    private fun togglePosition(position: Int) {
        expandPosition = if (position == expandPosition) {
            -1
        } else {
            position
        }
        notifyDataSetChanged()
    }
}