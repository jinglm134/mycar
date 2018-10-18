package com.jaylm.mycar.bean

import com.chad.library.adapter.base.entity.SectionEntity
import com.jaylm.mycar.bean.host.NewsBean

/**
 * Created by jaylm
 * on 2018/10/16.
 */
class SectionNewsBean(data: NewsBean) : SectionEntity<NewsBean>(data) {
    init {
        isHeader = "NORMAL" == data.layout
    }
}