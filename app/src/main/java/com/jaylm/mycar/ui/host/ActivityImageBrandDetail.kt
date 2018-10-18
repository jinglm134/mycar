package com.jaylm.mycar.ui.host

import android.os.Bundle
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.host.ImageBrandDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_image_brand_detail.*

/**
 * Created by jaylm
 * on 2018/10/18.
 */
class ActivityImageBrandDetail : BaseActivity(), CallBack {


    private var mGroupId = 0
    private var mName = ""
    private var mTotal = 0
    private var mIndex = 0
    private var mIndex1 = 1
    private var mIndex2 = 1
    private var mIndex3 = 1
    private var mIndex4 = 1
    private lateinit var mData: ImageBrandDetailBean
    private lateinit var fragment1: FragmentImageBrandDetail
    private lateinit var fragment2: FragmentImageBrandDetail
    private lateinit var fragment3: FragmentImageBrandDetail
    private lateinit var fragment4: FragmentImageBrandDetail

    override fun bindLayout(): Int {
        return R.layout.activity_image_brand_detail
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        mGroupId = bundle.getInt("groupId", 0)
        mName = bundle.getString("name", "")
    }

    override fun initView() {
        super.initView()

        tv_name.text = mName
        loadData()
    }


    private fun loadData() {

        WebList.trimpicgroup(mGroupId, object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                mData = GsonUtils.parseJsonWithGson(response.body(), ImageBrandDetailBean::class.java)
                invalidateData()
            }

        })
    }

    private fun invalidateData() {
        mTotal = mData.outsideCount
        mIndex = mIndex1
        setHeader(String.format("%s / %s张", mIndex, mTotal))

        fragment1 = FragmentImageBrandDetail.newInstance(1, mData.outsideList)
        fragment2 = FragmentImageBrandDetail.newInstance(2, mData.insideList)
        fragment3 = FragmentImageBrandDetail.newInstance(3, mData.configList)
        fragment4 = FragmentImageBrandDetail.newInstance(4, mData.otherList)
        smartReplaceFragment(R.id.frameLayout, fragment1, fragment1::class.java.simpleName + "1")


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {

                R.id.rb_1 -> {
                    mTotal = mData.outsideCount
                    mIndex = mIndex1
                    smartReplaceFragment(R.id.frameLayout, fragment1, fragment1::class.java.simpleName + "1")
                }

                R.id.rb_2 -> {
                    mTotal = mData.insideCount
                    mIndex = mIndex2
                    smartReplaceFragment(R.id.frameLayout, fragment2, fragment1::class.java.simpleName + "2")
                }

                R.id.rb_3 -> {
                    mTotal = mData.configCount
                    mIndex = mIndex3
                    smartReplaceFragment(R.id.frameLayout, fragment3, fragment1::class.java.simpleName + "3")
                }

                R.id.rb_4 -> {
                    mTotal = mData.otherCount
                    mIndex = mIndex4
                    smartReplaceFragment(R.id.frameLayout, fragment4, fragment1::class.java.simpleName + "4")
                }
            }

            setHeader(String.format("%s / %s张", mIndex, mTotal))

        }
    }

    override fun onScrollerChangedListener(type: Int, pos: Int) {
        when (type) {
            1 -> {
                mIndex1 = pos + 1
                mIndex = mIndex1
            }
            2 -> {
                mIndex2 = pos + 1
                mIndex = mIndex2
            }
            3 -> {
                mIndex3 = pos + 1
                mIndex = mIndex3
            }
            4 -> {
                mIndex4 = pos + 1
                mIndex = mIndex4
            }
        }
        setHeader(String.format("%s / %s张", mIndex, mTotal))
    }

}