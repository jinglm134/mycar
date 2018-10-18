package com.jaylm.mycar.ui.host

import android.content.Context
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.ImageView
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseFragment
import com.jaylm.mycar.bean.host.ImageBrandDetailBean
import com.jaylm.mycar.tool.bindArgument
import com.jaylm.mycar.ui.release.util.ImageUtils
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_exam_two.*

/**
 * Created by jaylm
 * on 2018/10/18.
 */
class FragmentImageBrandDetail : BaseFragment() {

    private val mData: ArrayList<ImageBrandDetailBean.ImageListBean> by bindArgument("data")
    private val mType: Int by bindArgument("type")
    private lateinit var mCallBack: CallBack

    override fun bindLayout(): Int {
        return R.layout.fragment_image_brand_detail
    }

    companion object {
        fun newInstance(type: Int, data: ArrayList<ImageBrandDetailBean.ImageListBean>): FragmentImageBrandDetail {
            val fragmentImageBrandDetail = FragmentImageBrandDetail()
            val bundle = Bundle()
            bundle.putParcelableArrayList("data", data)
            bundle.putInt("type", type)
            fragmentImageBrandDetail.arguments = bundle
            return fragmentImageBrandDetail
        }
    }

    override fun initView() {
        super.initView()
        mCallBack = activity as CallBack

        val images = ArrayList<String>()
        mData.forEach {
            val pic = it.picStdLinkByDefaultProtocol
            val url = if (!pic.startsWith("http")) {
                String.format("http:%s", pic)
            } else {
                pic
            }
            images.add(url)
        }

        banner.setImages(images).setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any, imageView: ImageView?) {
                ImageUtils.showImage(context, path.toString(), imageView)
            }
        })
//                .setDelayTime(5000)
//                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
//                .setIndicatorGravity(BannerConfig.RIGHT)//指示器居右
//                .setBannerAnimation(Transformer.Stack)
                .isAutoPlay(false)
                .start()

    }

    override fun setListener() {
        super.setListener()
        banner.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mCallBack.onScrollerChangedListener(mType, position)
            }

        })

//        banner.setOnBannerListener { position ->
//        }
    }
}

