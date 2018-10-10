package com.jaylm.mycar.ui

import android.support.design.widget.TabLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.ui.exam.ExamFourFragment
import com.jaylm.mycar.ui.exam.ExamOneFragment
import com.jaylm.mycar.ui.exam.ExamThreeFragment
import com.jaylm.mycar.ui.exam.ExamTwoFragment
import kotlinx.android.synthetic.main.fragment_exam.*

/**
 * 考试
 * Created by jaylm
 * on 2018/10/3.
 */
class ExamFragment : BaseFragment() {

    private val mTitle: Array<String> = arrayOf("科目一", "科目二", "科目三", "科目四")
    private lateinit var examOneFragment: ExamOneFragment
    private lateinit var examTwoFragment: ExamTwoFragment
    private lateinit var examThreeFragment: ExamThreeFragment
    private lateinit var examFourFragment: ExamFourFragment

    override fun bindLayout(): Int {
        return R.layout.fragment_exam
    }

    override fun initView() {
        super.initView()


        for (i in mTitle.indices) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitle[i]))
        }
        tabLayout.tabMode = TabLayout.MODE_FIXED

        examOneFragment = ExamOneFragment()
        examTwoFragment = ExamTwoFragment()
        examThreeFragment = ExamThreeFragment()
        examFourFragment = ExamFourFragment()

        smartReplaceFragment(R.id.frameLayout, examOneFragment)
    }

    override fun setListener() {
        super.setListener()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> smartReplaceFragment(R.id.frameLayout, examOneFragment)
                    1 -> smartReplaceFragment(R.id.frameLayout, examTwoFragment)
                    2 -> smartReplaceFragment(R.id.frameLayout, examThreeFragment)
                    3 -> smartReplaceFragment(R.id.frameLayout, examFourFragment)
                }
            }

        })
    }
}