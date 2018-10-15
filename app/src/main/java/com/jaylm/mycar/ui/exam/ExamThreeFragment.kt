package com.jaylm.mycar.ui.exam

import android.os.Bundle
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.net.API
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.WebViewActivity
import kotlinx.android.synthetic.main.fragment_exam_three.*

/**
 * Created by jaylm
 * on 2018/10/10.
 */
class ExamThreeFragment : BaseFragment() {
    override fun bindLayout(): Int {
        return R.layout.fragment_exam_three
    }

    override fun initView() {
        super.initView()
        UShape.setBackgroundDrawable(tv_1, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_2, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_3, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_4, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
        UShape.setBackgroundDrawable(tv_5, UShape.getPressedDrawable(UShape.getColor(R.color.colorPrimary), UShape.getColor(R.color.c23), 6))
    }

    override fun setListener() {
        super.setListener()
        tv_1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试规则")
            bundle.putString("url", API.km3_ksgz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试流程")
            bundle.putString("url", API.km3_kslc)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_3.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试标准")
            bundle.putString("url", API.km3_hgbz)
            startActivity(WebViewActivity::class.java, bundle)
        }
        tv_4.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考试要点")
            bundle.putString("url", API.km3_ksyd)
            startActivity(WebViewActivity::class.java, bundle)

        }
        tv_5.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", "考前冲刺")
            bundle.putString("url", API.jinnang_3)
            startActivity(WebViewActivity::class.java, bundle)

        }

        ll_jclk.setOnClickListener {
            startActivity(ActivityJCLK::class.java)
        }

        ll_zhqb.setOnClickListener {
            startActivity(ActivityZHQB::class.java)
        }

        ll_lkkj.setOnClickListener {
            startActivity(ActivityLKKJ::class.java)
        }

        ll_dtjq.setOnClickListener {
            startActivity(ActivityDTJQ::class.java)
        }

        ll_yk.setOnClickListener {
            startActivity(ActivityYK::class.java)
        }

    }
}