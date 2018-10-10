package com.jaylm.mycar.net

import com.jaylm.mycar.bean.exam.ExamCheatBean
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

    fun getNNCorp(corpId: String, callBack: BaseCallBack) {
        OkGo.post<String>(API.GetNNCorp)
                .params("CorpId", corpId)
                .params("Lat", 22.817746)
                .params("Lon", 108.36637)
                .execute(callBack)
    }

    fun getCorpSet(corpId: String, callBack: BaseCallBack) {
        OkGo.post<String>(API.GetCorpSet)
                .params("CorpId", corpId)
                .params("Source", 22.0)
                .execute(callBack)
    }

    fun CorpCoachsInfo(corpId: String, callBack: BaseCallBack) {
        OkGo.post<String>(API.CorpCoachsInfo)
                .params("CorpId", corpId)
                .params("PageIndex", 1)
                .params("PageSize", 20)
                .params("Source", 0)
                .execute(callBack)
    }

    fun CommentInfo(corpId: String, callBack: BaseCallBack) {
        OkGo.post<String>(API.CommentInfo)
                .params("CorpId", corpId)
                .params("PageIndex", 1)
                .params("PageSize", 50)
                .params("Source", 0)
                .execute(callBack)
    }

    fun Onearticles(pageindex: Int, callBack: BaseCallBack) {
        OkGo.get<String>(API.Onearticles)
                .params("pagesize", 20)
                .params("pageindex", pageindex)
                .execute(callBack)
    }

    fun Onecommentlist(url: Long, callBack: BaseCallBack) {
        OkGo.get<String>(String.format("https://bbsapi.jxedt.com//news/api/%s/comment/list", url))
                .params("pagesize", 50)
                .params("pageindex", 1)
                .params("url", String.format("/news/api/%s/comment/list", url))
                .execute(callBack)
    }

}