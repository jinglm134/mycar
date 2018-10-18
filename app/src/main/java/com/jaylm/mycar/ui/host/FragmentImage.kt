package com.jaylm.mycar.ui.host

import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.tool.UShape
import kotlinx.android.synthetic.main.fragment_image.*

/**
 * Created by jaylm
 * on 2018/10/18.
 */
class FragmentImage : BaseFragment() {

    private lateinit var fragmentImageBrand: FragmentImageBrand
    private lateinit var fragmentImageGirl1: FragmentImageGirl
    private lateinit var fragmentImageGirl2: FragmentImageGirl

    override fun bindLayout(): Int {
        return R.layout.fragment_image
    }

    override fun initView() {
        super.initView()
        UShape.setBackgroundDrawable(rb_1, UShape.getCheckedDrawable(UShape.getColor(R.color.c10), UShape.getColor(R.color.colorPrimary), 6))
        UShape.setBackgroundDrawable(rb_2, UShape.getCheckedDrawable(UShape.getColor(R.color.c10), UShape.getColor(R.color.colorPrimary), 6))
        UShape.setBackgroundDrawable(rb_3, UShape.getCheckedDrawable(UShape.getColor(R.color.c10), UShape.getColor(R.color.colorPrimary), 6))



        fragmentImageBrand = FragmentImageBrand()
        fragmentImageGirl1 = FragmentImageGirl.newInstance(1011)
        fragmentImageGirl2 = FragmentImageGirl.newInstance(1199)

        smartReplaceFragment(R.id.frameLayout, fragmentImageBrand)

    }

    override fun setListener() {
        super.setListener()
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rb_1 -> smartReplaceFragment(R.id.frameLayout, fragmentImageBrand)
                R.id.rb_2 -> smartReplaceFragment(R.id.frameLayout, fragmentImageGirl1, fragmentImageGirl1::class.java.simpleName + "1")
                R.id.rb_3 -> smartReplaceFragment(R.id.frameLayout, fragmentImageGirl2, fragmentImageGirl2::class.java.simpleName + "2")
            }
        }
    }
}