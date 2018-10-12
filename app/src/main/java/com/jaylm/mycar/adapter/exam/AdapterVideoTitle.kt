package com.jaylm.mycar.adapter.exam

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.ExamKM2Video
import com.jaylm.mycar.tool.UShape

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterVideoTitle : BaseQuickAdapter<ExamKM2Video.CarbrandBean, BaseViewHolder>(R.layout.item_vedio_title) {

    private var mBrandId = 1
    override fun convert(helper: BaseViewHolder, item: ExamKM2Video.CarbrandBean) {
        val textView = helper.getView<TextView>(R.id.textView)
        textView.text = item.brandName
        if (mBrandId == item.brandId) {
            UShape.setBackgroundDrawable(textView, UShape.getCornerDrawable(UShape.getColor(R.color.colorPrimary), 100))
            textView.setTextColor(UShape.getColor(R.color.c14))
        } else {
            UShape.setBackgroundDrawable(textView, UShape.getCornerDrawable(UShape.getColor(R.color.c10), 100))
            textView.setTextColor(UShape.getColor(R.color.c6))
        }
    }

    fun setNewData(data: MutableList<ExamKM2Video.CarbrandBean>?, brandId: Int) {
        mBrandId = brandId
        if (mBrandId < 1) {
            mBrandId = 1
        }
        super.setNewData(data)
    }

}