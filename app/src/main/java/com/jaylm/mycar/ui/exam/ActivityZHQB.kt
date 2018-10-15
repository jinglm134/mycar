package com.jaylm.mycar.ui.exam

import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import kotlinx.android.synthetic.main.activity_lkkj.*

/**
 * 路考口诀
 * Created by jaylm
 * on 2018/10/13.
 */
class ActivityZHQB : BaseActivity() {
    override fun bindLayout(): Int {
        return R.layout.activity_zhqb
    }

    override fun initView() {
        super.initView()
        setHeader("做好七步")
    }
}