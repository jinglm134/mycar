package com.jaylm.mycar.net

/**
 * Created by jaylm
 * on 2018/10/1.
 */
object API {
    val INDEX = "http://xm.anzhuo9.com/index.php?s=/api/Version/index"
    val BANNER_MAINTAIN = "http://app.baichebao.com/banner/list?uid=0&ver=1.1&lng=0&sign=d7d458fdea78a63bf837d3f7fb33077e&region_id=52&source=android&car_id=0&lat=0"//首页banner
    val RECOMMEND_LIST = "http://app.baichebao.com/recommend/list?uid=0&ver=1.1&lng=0&sign=11b1f0fcfb5c43cf28bfe613a6e795c6&region_id=52&source=android&car_id=0&lat=0&car_ids=0"//首页推荐
    val SearchNNCorps = "http://www.gxxcc.com:80/JP_NNPay/api/v1/JPApp/Corp/SearchNNCorps"//驾校列表
    val GetNNCorp = "http://www.gxxcc.com:80/JP_NNPay/api/v1/JPApp/Corp/GetNNCorp"//驾校简介
    val GetCorpSet = "http://www.gxxcc.com:80/JP_NNPay/api/v1/JPApp/CorpSet/Sets"//驾校套餐
    val CorpCoachsInfo = "http://www.gxxcc.com:80/JP_NNPay/api/v1/JPApp/Coach/CorpCoachsInfo"//教练
    val CommentInfo = "http://www.gxxcc.com:80/JP_NNPay/api/v1/JPApp/Comment/CorpScoreCommentInfo"//评价
    val Onearticles = "https://bbsapi.jxedt.com/listnews/204/articles"//科一秘籍
    val Onecommentlist = "https://bbsapi.jxedt.com//news/api/%s/comment/list"//科一秘籍评论
    val videoClass = "https://api.jxedt.com/media/videoClass/?videotype=2"//科一学车课堂
    val info_5 = "http://m.jxedt.com/info_5/"//交通标志大全
    val list_664 = "http://m.jxedt.com/list_664/"//仪表指示器
    val list_665 = "http://m.jxedt.com/list_665/"//交警手势
    val list_666 = "http://m.jxedt.com/list_666/"//车内功能按键
    val list_667 = "http://m.jxedt.com/list_667/"//责任图解
    val list_726 = "http://m.jxedt.com/list_726/"//色盲测试

}