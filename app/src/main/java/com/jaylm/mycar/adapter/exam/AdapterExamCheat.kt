package com.jaylm.mycar.adapter.exam

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.jaylm.mycar.R
import com.jaylm.mycar.bean.exam.ExamCheatBean
import com.jaylm.mycar.ui.release.util.ImageUtils

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class AdapterExamCheat : BaseQuickAdapter<ExamCheatBean, BaseViewHolder>(R.layout.item_exam_cheat) {

    override fun convert(helper: BaseViewHolder, item: ExamCheatBean) {
        helper.setText(R.id.tv_name, item.title)
                .setText(R.id.tv_seek, item.likenum.toString())
                .setText(R.id.tv_assess, item.cmmtNum.toString())
                .setText(R.id.tv_time, item.ctime)
        if (item.imgNum > 0) {
            ImageUtils.showImage(mContext, item.imgages[0], helper.getView(R.id.iv_cheat))
        }
    }
}