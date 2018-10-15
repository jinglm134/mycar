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

    val toutiao_info = "https://api.mnks.cn/v1/toutiao/app_toutiao_info.php"//科二头条
    val appbanner = "https://rapi.mnks.cn/data/banner/app_banner_com.runbey.ybjk_kjz_km2.json"//科二banner

    val jinnang_2 = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/jinnang/_html/jinnang_2.html"//科二考前冲刺
    val km2_ksyd = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_ksyd.html"//科二考试要点
    val km2_hgbz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_hgbz.html"//科二考试标准
    val km2_kslc = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_kslc.html"//科二考试流程
    val km2_ksgz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_ksgz.html"//科二考试规则
    val km2_index = "https://api.jxedt.com/media/index"//科二视频首页列表
    val km2_list = "https://api.jxedt.com/media/list"//科二视频更多页列表
    val km2_detail = "https://api.jxedt.com/media/detail/?carbrand=1&pageindex=1&lastid=0&videotype=1"//科二视频详情

    val jinnang_3 = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/jinnang/_html/jinnang_3.html"//科三考前冲刺
    val km3_ksyd = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km3_ksyd.html"//科三考试要点
    val km3_hgbz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km3_hgbz.html"//科三考试标准
    val km3_kslc = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km3_kslc.html"//科三考试流程
    val km3_ksgz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km3_ksgz.html"//科三考试规则

}