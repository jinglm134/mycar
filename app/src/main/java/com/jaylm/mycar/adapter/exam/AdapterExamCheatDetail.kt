package com.jaylm.mycar.adapter.exam

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.ExamCheatBean
import com.jaylm.mycar.bean.exam.ExamCheatDetailBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterExamCheatDetail : BaseQuickAdapter<ExamCheatDetailBean, BaseViewHolder>(R.layout.item_exam_cheat_detail) {

    override fun convert(helper: BaseViewHolder, item: ExamCheatDetailBean) {
        helper.setText(R.id.tv_name, item.nickname)
                .setText(R.id.tv_time_address, String.format("%s %s", item.commentdate, item.groups[0].title))
                .setText(R.id.tv_assess, item.comment)
        ImageUtils.showImage(mContext, item.face, helper.getView(R.id.civ_header))
    }
}