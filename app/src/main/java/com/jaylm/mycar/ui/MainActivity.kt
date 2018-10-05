package com.jaylm.mycar.ui

import android.support.design.widget.TabLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.ui.driverschool.DriverSchoolFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var maintainFragment: MaintainFragment
    private lateinit var buyFragment: BuyFragment
    private lateinit var peripheryFragment: PeripheryFragment
    private lateinit var askFragment: AskFragment
    private lateinit var schoolFragment: DriverSchoolFragment
    private val mHeader: Array<String> = arrayOf("保养", "购买", "周边", "咨询", "驾校")

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        setHeader(mHeader[0])

        for (i in 0 until mHeader.size) {
            tabLayout.addTab(tabLayout.newTab().setText(mHeader[i]))
        }
        tabLayout.tabMode = TabLayout.MODE_FIXED

        maintainFragment = MaintainFragment()
        buyFragment = BuyFragment()
        peripheryFragment = PeripheryFragment()
        askFragment = AskFragment()
        schoolFragment = DriverSchoolFragment()

        smartReplaceFragment(R.id.frameLayout, maintainFragment)
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
            0 -> smartReplaceFragment(R.id.frameLayout, maintainFragment)
            1 -> smartReplaceFragment(R.id.frameLayout, buyFragment)
            2 -> smartReplaceFragment(R.id.frameLayout, peripheryFragment)
            3 -> smartReplaceFragment(R.id.frameLayout, askFragment)
            4 -> smartReplaceFragment(R.id.frameLayout, schoolFragment)
        }
        setHeader(mHeader[tab.position])
    }
}