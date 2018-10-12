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

    val vediorecommed = "http://sirius.kakamobi.cn/api/open/exam-project/list.htm?_platform=android&_srv=t&_appName=jiakaobaodian&_product=%E9%A9%BE%E8%80%83%E5%AE%9D%E5%85%B8&_vendor=baidu&_renyuan=XYX&_version=7.1.9&_system=LMY48Z&_manufacturer=samsung&_systemVersion=5.1.1&_device=SM-G610F&_imei=77777777777777777777777777777777&_productCategory=jiakaobaodian&_operator=M&_androidId=59d9b44cda430243&_mac=64%3Af5%3A80%3A71%3A8a%3A2b&_appUser=ae85922ac12541dbbe110e7870599cac&_pkgName=com.handsgo.jiakao.android&_screenDpi=1.2&_screenWidth=720&_screenHeight=1280&_network=wifi&_launch=1&_firstTime=2018-10-12%2014%3A33%3A35&_apiLevel=22&_userCity=310000&_p=464D555059511944545A5C5B4C55&_ipCity=0&_j=1.0&schoolName=%E6%9C%AA%E6%8A%A5%E8%80%83%E9%A9%BE%E6%A0%A1&schoolCode=-1&_webviewVersion=4.7&_mcProtocol=4.1&_r=21b08dd0fcb74ef68a57422b226756ee&tiku=car&kemu=2&pageSize=100"//科目二视频推荐
    val jinnang_2 = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/jinnang/_html/jinnang_2.html"//科二考前冲刺
    val km2_ksyd = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_ksyd.html"//科二考试要点
    val km2_hgbz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_hgbz.html"//科二考试标准
    val km2_kslc = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_kslc.html"//科二考试流程
    val km2_ksgz = "https://j1.58cdn.com.cn/dist/jxedt/h5/activity/article/_html/km2_ksgz.html"//科二考试规则
}