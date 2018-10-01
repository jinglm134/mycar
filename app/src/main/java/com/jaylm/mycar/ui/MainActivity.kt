package com.jaylm.mycar.ui

import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.net.WebList
import org.jetbrains.anko.button
import org.jetbrains.anko.editText
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class MainActivity : BaseActivity() {


    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        verticalLayout {
            val etName = editText()
            button("Say Hello") {
                onClick {
                    toast("Hello, ${etName.text}!")
                }
            }
        }
    }
}