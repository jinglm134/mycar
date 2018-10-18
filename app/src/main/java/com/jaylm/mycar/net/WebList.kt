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

    fun videoClass(callBack: BaseCallBack) {
        OkGo.get<String>(API.videoClass)
                .execute(callBack)
    }

    fun appBanner(callBack: BaseCallBack) {
        OkGo.get<String>(API.appbanner)
                .execute(callBack)
    }


    fun km2_sp(url: String, callBack: BaseCallBack) {
        OkGo.get<String>(url)
                .execute(callBack)
    }

    //基础首页
    fun km2_jc_index(channelid: Int, carbrand: Int, callBack: BaseCallBack) {
        val url = API.km2_index + "/?carbrand=" + carbrand + "&channelid=" + channelid + "&videotype=1"
        km2_sp(url, callBack)
    }

    //热点首页
    fun km2_rd_index(channelid: Int, callBack: BaseCallBack) {
        val url = API.km2_index + "/?channelid=" + channelid + "&videotype=0"
        km2_sp(url, callBack)
    }

    //基础列表
    fun km2_jc_list(channelid: Int, carbrand: Int, pageindex: Int, callBack: BaseCallBack) {
        val url = API.km2_list + "/?carbrand=" + carbrand + "&pageindex=" + pageindex + "&channelid=" + channelid + "&videotype=1"
        km2_sp(url, callBack)
    }

    //热点列表
    fun km2_rd_list(channelid: Int, pageindex: Int, callBack: BaseCallBack) {
        val url = API.km2_list + "/?channelid=" + channelid + "&videotype=0&pageindex=" + pageindex
        km2_sp(url, callBack)
    }

    fun km2_detail(topicid: Long, callBack: BaseCallBack) {
        val url = API.km2_detail + "&topicid=" + topicid
        OkGo.get<String>(url)
                .execute(callBack)
    }

    fun toutiao_info(model: String, pageNum: Int, pageSize: Int, callBack: BaseCallBack) {
        OkGo.post<String>(API.toutiao_info)
                .params("model", model)
                .params("pageNum", pageNum)
                .params("pageSize", pageSize)
                .execute(callBack)
    }

    fun news(type: Int, isPullDown: Boolean, id: Long, callBack: BaseCallBack) {
        val idType = if (isPullDown) {
            "?since_id="
        } else {
            "?max_id="
        }

        val url = if (id == 0L) {
            API.news + type
        } else {
            API.news + type + idType + id
        }
        OkGo.get<String>(url).execute(callBack)
    }

    fun recommend(page: Int, isPullDown: Boolean, callBack: BaseCallBack) {
        val pull_direction = if (isPullDown) {
            "down"
        } else {
            "up"
        }
        val url = API.recommend + "&pull_direction=" + pull_direction + "&page=" + page
        OkGo.get<String>(url).execute(callBack)
    }

    fun original(isPullDown: Boolean, id: Long, callBack: BaseCallBack) {
        val idType = if (isPullDown) {
            "?since_id="
        } else {
            "?max_id="
        }
        val url = API.original + idType + id
        OkGo.get<String>(url).execute(callBack)
    }


    fun newsDetail(id: Int, callBack: BaseCallBack) {
        val url = API.newsDeatil + id + "/detail"
        OkGo.get<String>(url).execute(callBack)
    }

    fun listOrderByUpdateTime(id: Int = -1, callBack: BaseCallBack) {
        OkGo.get<String>(API.listOrderByUpdateTime + id).execute(callBack)
    }

    fun trimpicgroup(groupId: Int, callBack: BaseCallBack) {
        OkGo.get<String>(API.trimpicgroup + groupId).execute(callBack)
    }

    fun picgroup(start: Int, callBack: BaseCallBack) {
        OkGo.get<String>(API.picgroup + start).execute(callBack)
    }

    fun girlgroup(groupId: Int, callBack: BaseCallBack) {
        OkGo.get<String>(API.girlgroup + groupId).execute(callBack)
    }
}