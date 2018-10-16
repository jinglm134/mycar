package com.jaylm.mycar.ui

import android.support.design.widget.TabLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 保养页面
 * Created by jaylm
 * on 2018/10/3.
 */
class MainFragment : BaseFragment() {
    private val mHeader: Array<String> = arrayOf("买车", "用车", "新能源", "科技", "文化")
    private val mHeaderId = intArrayOf(775, 777, 1421, 1422, 776)
    private lateinit var mFragments: ArrayList<FragmentNews>


    override fun bindLayout(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {
        super.initView()

        for (i in 0 until mHeader.size) {
            tabLayout.addTab(tabLayout.newTab().setText(mHeader[i]))
        }
        tabLayout.tabMode = TabLayout.MODE_FIXED

        mFragments = ArrayList()
        for (i in mHeader.indices) {
            val fragment = FragmentNews.newInstance(mHeaderId[i])
            mFragments.add(fragment)
        }

        smartReplaceFragment(R.id.frameLayout, mFragments[0], mFragments[0]::class.java.simpleName + "0")
    }

    override fun setListener() {
        super.setListener()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                smartReplaceFragment(R.id.frameLayout, mFragments[tab.position], mFragments[tab.position]::class.java.simpleName + tab.position)
            }

        })
    }
}