package com.jaylm.mycar.ui.host

import android.os.Bundle
import android.view.View
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.bean.host.ImageBrandDetailBean
import com.jaylm.mycar.net.BaseCallBack
import com.jaylm.mycar.net.WebList
import com.jaylm.mycar.util.GsonUtils
import com.lzy.okgo.model.Response
import kotlinx.android.synthetic.main.activity_image_brand_detail.*
import org.json.JSONObject

/**
 * Created by jaylm
 * on 2018/10/18.
 */
class ActivityImageGirlDetail : BaseActivity(), CallBack {


    private var mGroupId = 0
    private var mName = ""
    private lateinit var mData: ArrayList<ImageBrandDetailBean.ImageListBean>
    private lateinit var fragment: FragmentImageBrandDetail
    private var mTotal = 0
    private var mIndex = 1

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

        radioGroup.visibility = View.GONE
        tv_name.text = mName
        mData = ArrayList()
        loadData()
    }


    private fun loadData() {

        WebList.girlgroup(mGroupId, object : BaseCallBack(mActivity, true) {
            override fun onSuccess(jsonString: String) {
            }

            override fun onSuccess(response: Response<String>) {
//                super.onSuccess(response)
                mData.clear()
                val data = GsonUtils.parseJsonArrayWithGson(JSONObject(response.body()).optString("result"), ImageBrandDetailBean.ImageListBean::class.java)
                mData.addAll(data)
                invalidateData()
            }

        })
    }

    private fun invalidateData() {
        mTotal = mData.size
        setHeader(String.format("%s / %s张", mIndex, mTotal))

        fragment = FragmentImageBrandDetail.newInstance(1, mData)
        smartReplaceFragment(R.id.frameLayout, fragment)

    }

    override fun onScrollerChangedListener(type: Int, pos: Int) {
        when (type) {
            1 -> {
                mIndex = pos + 1
            }
        }
        setHeader(String.format("%s / %s张", mIndex, mTotal))
    }

}