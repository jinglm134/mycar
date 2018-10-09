package com.jaylm.mycar.ui

import android.net.Uri
import android.os.Bundle
import cn.jzvd.Jzvd
import com.jaylm.mycar.R
import com.jaylm.mycar.base.BaseActivity
import kotlinx.android.synthetic.main.layout_video_player.*

/**
 * Created by jaylm
 * on 2018/10/9.
 */
class ActivityVideoPlayer : BaseActivity() {

    private lateinit var mUrl: String
    private lateinit var mThumb: String
    private lateinit var mTitle: String
    override fun bindLayout(): Int {
        return R.layout.layout_video_player
    }

    override fun initParams(bundle: Bundle) {
        super.initParams(bundle)
        mUrl = bundle.getString("url", "")
        mThumb = bundle.getString("thumb", "")
        mTitle = bundle.getString("title", "")
    }

    override fun initView() {
        super.initView()
        setHeader("驾校视频")

        videoPlayer.setUp(mUrl, mTitle, Jzvd.SCREEN_WINDOW_NORMAL)
        videoPlayer.thumbImageView.setImageURI(Uri.parse(mThumb))
    }

    override fun onBackPressed() {
        if (Jzvd.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        Jzvd.releaseAllVideos()
    }
}