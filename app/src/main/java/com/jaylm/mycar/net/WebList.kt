package com.jaylm.mycar.net

import com.lzy.okgo.OkGo

/**
 * Created by jaylm
 * on 2018/10/1.
 */
object WebList {

    fun getIndex(appId: Long, callBack: BaseCallBack) {
        OkGo.post<String>(API.INDEX)
                .params("app_id", appId)
                .params("type", "android")
                .execute(callBack)
    }

    fun bannerMaintain(callBack: BaseCallBack) {
//        OkGo.post<String>(API.BANNER_MAINTAIN)
//                .execute(callBack)
        OkGo.get<String>(API.BANNER_MAINTAIN)
                .execute(callBack)
    }


    fun recommendList(callBack: BaseCallBack) {
        OkGo.get<String>(API.RECOMMEND_LIST)
                .execute(callBack)
    }
}