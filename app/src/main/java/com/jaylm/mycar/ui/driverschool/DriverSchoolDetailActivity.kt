package com.jaylm.mycar.ui.driverschool

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.SchoolDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.tool.UShape
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.jaylm.mycar.util.GsonUtils
import com.lzy.okgo.model.Response
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_driver_school_detail.*
import org.json.JSONObject

/**
 * 驾校详情界面
 * Created by jaylm
 * on 2018/10/5.
 */
class DriverSchoolDetailActivity : BaseActivity() {
    private lateinit var mCorpId: String
    private lateinit var mData: SchoolDetailBean

    private var schoolInfoFragment: SchoolInfoFragment? = null
    private var schoolCoachFragment: SchoolCoachFragment? = null
    private var schoolTariffFragment: SchoolTariffFragment? = null
    private var schoolAssessFragment: SchoolAssessFragment? = null

    override fun bindLayout(): Int {
        return R.layout.activity_driver_school_detail
    }


    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        mCorpId = bundle.getString("corpId", "")
    }

    override fun initView() {
        super.initView()
        setHeader("驾校详情")


        tabLayout.addTab(tabLayout.newTab().setText("简介"))
        tabLayout.addTab(tabLayout.newTab().setText("套餐"))
        tabLayout.addTab(tabLayout.newTab().setText("教练"))
        tabLayout.addTab(tabLayout.newTab().setText("评价"))
        tabLayout.tabMode = TabLayout.MODE_FIXED
        loadData()
    }

    override fun setListener() {
        super.setListener()
        banner.setOnBannerListener { position ->

        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        if (schoolInfoFragment == null) {
                            schoolInfoFragment = SchoolInfoFragment.newInstance(mData)
                        }
                        smartReplaceFragment(R.id.frameLayout, schoolInfoFragment!!)
                    }
                    1 -> {
                        if (schoolTariffFragment == null) {
                            schoolTariffFragment = SchoolTariffFragment()
                        }
                        smartReplaceFragment(R.id.frameLayout, schoolTariffFragment!!)
                    }
                    2 -> {
                        if (schoolCoachFragment == null) {
                            schoolCoachFragment = SchoolCoachFragment()
                        }
                        smartReplaceFragment(R.id.frameLayout, schoolCoachFragment!!)
                    }
                    3 -> {
                        if (schoolAssessFragment == null) {
                            schoolAssessFragment = SchoolAssessFragment()
                        }
                        smartReplaceFragment(R.id.frameLayout, schoolAssessFragment!!)
                    }
                }
            }

        })
    }


    private fun loadData() {
        WebList.getNNCorp(mCorpId, object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                val jsonObject = JSONObject(response.body())
                /*JsonObject.opt 无key值时会得到默认值,JsonObject.get无key值会出错*/
                val data = jsonObject.optString("Data")
                mData = GsonUtils.parseJsonWithGson(data, SchoolDetailBean::class.java)
                bindData()

            }
        })
    }

    private fun bindData() {
        UShape.setBackgroundDrawable(tv_distance, UShape.getCornerDrawable(UShape.getColor(R.color.colorPrimary), 6))
        banner.setImages(mData.corpPics).setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any, imageView: ImageView?) {
                ImageUtils.showImage(context, path.toString(), imageView)
            }
        })
                .setDelayTime(5000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setIndicatorGravity(BannerConfig.RIGHT)//指示器居右
                .setBannerAnimation(Transformer.Stack)
                .start()

        tv_name.text = mData.corp_Name
        tv_distance.text = String.format("距离:%sKM", mData.distance)
        ratingBar.rating = mData.avgScore.toFloat()
        tv_discuss.text = String.format("%s评价", mData.commentCount)

        if (schoolInfoFragment == null) {
            schoolInfoFragment = SchoolInfoFragment.newInstance(mData)
        }
        smartReplaceFragment(R.id.frameLayout, schoolInfoFragment!!)
    }
}