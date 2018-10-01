package com.jaylm.mycar.ui

import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        setHeader("每一个明天")
    }
}