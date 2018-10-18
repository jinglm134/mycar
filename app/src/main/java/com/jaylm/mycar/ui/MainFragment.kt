package com.jaylm.mycar.ui

import android.support.design.widget.TabLayout
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.ui.host.FragmentImage
import com.jaylm.mycar.ui.host.FragmentNews
import com.jaylm.mycar.ui.host.FragmentOriginal
import com.jaylm.mycar.ui.host.FragmentRecommend
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * 保养页面
 * Created by jaylm
 * on 2018/10/3.
 */
class MainFragment : BaseFragment() {
    private val mHeader: Array<String> = arrayOf("推荐", "精选", "图片", "用车")
    //    private val mHeaderId = intArrayOf(775, 777, 1421, 1422, 776)
    private lateinit var fragmentRecommend: FragmentRecommend
    private lateinit var fragmentOriginal: FragmentOriginal
    private lateinit var fragmentImage: FragmentImage
    private lateinit var fragmentNews: FragmentNews

    override fun bindLayout(): Int {
        return R.layout.fragment_main
    }

    override fun initView() {
        super.initView()

        for (i in 0 until mHeader.size) {
            tabLayout.addTab(tabLayout.newTab().setText(mHeader[i]))
        }
        tabLayout.tabMode = TabLayout.MODE_FIXED

        fragmentRecommend = FragmentRecommend()
        fragmentOriginal = FragmentOriginal()
        fragmentImage = FragmentImage()
        fragmentNews = FragmentNews.newInstance(775)

        smartReplaceFragment(R.id.frameLayout, fragmentRecommend)
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
                    0 -> smartReplaceFragment(R.id.frameLayout, fragmentRecommend)
                    1 -> smartReplaceFragment(R.id.frameLayout, fragmentOriginal)
                    2 -> smartReplaceFragment(R.id.frameLayout, fragmentImage)
                    3 -> smartReplaceFragment(R.id.frameLayout, fragmentNews)
                }
            }

        })
    }
}