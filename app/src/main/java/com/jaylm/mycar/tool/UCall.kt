package com.jaylm.mycar.tool

import android.app.Activity
import android.content.Intent
import android.net.Uri

/**
 * Created by jaylm
 * on 2018/10/9.
 */
class UCall {
    companion object {
        fun dialPhone(activity: Activity, phoneNum: String) {
            val intent = Intent(Intent.ACTION_DIAL)
            val data = Uri.parse(String.format("tel:%s", phoneNum))
            intent.data = data
            activity.startActivity(intent)
        }

//    fun callPhone(activity: Activity, phoneNum: String) {
//        val intent = Intent(Intent.ACTION_CALL)
//        val data = Uri.parse(String.format("tel:%s", phoneNum))
//        intent.data = data
//        activity.startActivity(intent)
//    }
    }

}