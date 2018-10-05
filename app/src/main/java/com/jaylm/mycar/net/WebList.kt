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

    fun schoolHot(filterType: Int, pageIndex: Int, callBack: BaseCallBack) {
        OkGo.post<String>(API.SearchNNCorps)
                .params("CantonCode", "")
                .params("FilterType", filterType)
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
    }

    fun getNNCorp(CorpId: String, callBack: BaseCallBack) {
        OkGo.post<String>(API.GetNNCorp)
                .params("CorpId", "")
                .params("Lat", 22.817746)
                .params("Lon", 108.36637)
                .execute(callBack)
    }
}