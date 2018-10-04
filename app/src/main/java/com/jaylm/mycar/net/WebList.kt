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

    fun schoolHot(pageIndex: Int, callBack: BaseCallBack) {
        OkGo.post<String>(API.SCHOOL_HOT)
                .params("CantonCode", "")
                .params("FilterType", 0)
                .params("GetLogo", 1)
                .params("GetMarks", 1)
                .params("GetSummary", 0)
                .params("IsRecommand", -1)
                .params("Lat", 22.817746)
                .params("Lon", 108.36637)
                .params("PageIndex", pageIndex)
                .params("PageSize", 20)
                .params("Source", 0)
                .execute(callBack)
//        "CantonCode": "",
//        "FilterType": 0,
//        "GetLogo": 1,
//        "GetMarks": 1,
//        "GetSummary": 0,
//        "IsRecommand": -1,
//        "Lat": 22.817746,
//        "Lon": 108.36637,
//        "PageIndex": 1,
//        "PageSize": 20,
//        "Source": 0

//                    "CantonCode": "",
//                    "FilterType": 0,
//                    "GetLogo": 1,
//                    "GetMarks": 1,
//                    "GetSummary": 0,
//                    "IsRecommand": -1,
//                    "Lat": 22.817746,
//                    "Lon": 108.36637,
//                    "PageIndex": 2,
//                    "PageSize": 20,
//                    "Source": 0
    }
}