package com.jaylm.mycar.net

import com.google.gson.Gson

/**
 * Created by jaylm
 * on 2018/10/1.
 */
class NetException(s: String) : IllegalStateException() {
    private var errorBean: LazyResponse<*> = Gson().fromJson(s, LazyResponse::class.java)

    fun getErrorBean(): LazyResponse<*>{
        return errorBean
    }
}