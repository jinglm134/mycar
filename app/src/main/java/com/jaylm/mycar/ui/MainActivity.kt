package com.jaylm.mycar.ui

import android.support.design.widget.TabLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.util.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var mainFragment: MainFragment
    private lateinit var examFragment: ExamFragment
    private lateinit var schoolFragment: SchoolFragment
    private val mHeader: Array<String> = arrayOf("首页", "考试", "驾校")
    private val clickTime = 3000
    private var currentTime = 0L

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHeader(mHeader[0])

        for (i in 0 until mHeader.size) {
            tabLayout.addTab(tabLayout.newTab().setText(mHeader[i]))
        }
        tabLayout.tabMode = TabLayout.MODE_FIXED

        mainFragment = MainFragment()
        examFragment = ExamFragment()
        schoolFragment = SchoolFragment()

        smartReplaceFragment(R.id.frameLayout, mainFragment)
    }

    override fun setListener() {
        super.setListener()
        tabLayout.addOnTabSelectedListener(this)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        when (tab.position) {
            0 -> smartReplaceFragment(R.id.frameLayout, mainFragment)
            1 -> smartReplaceFragment(R.id.frameLayout, examFragment)
            2 -> smartReplaceFragment(R.id.frameLayout, schoolFragment)
        }
        setHeader(mHeader[tab.position])
    }

    override fun onBackPressed() {
        val l = System.currentTimeMillis()
        if (l - currentTime <= clickTime) {
            super.onBackPressed()
        } else {
            currentTime = l
            ToastUtils.showShortToast(mActivity, "再按一次退出应用")
        }
    }
}