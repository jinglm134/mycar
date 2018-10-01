package com.jaylm.mycar.net

import java.io.Serializable

/**
 * Created by jaylm
 * on 2018/10/1.
 */
class LazyResponse<T> : Serializable {
    private var code: Int = 0
    private var msg: String = ""
    private var data: T? = null

    fun getCode(): Int {
        return code
    }

    fun setCode(code: Int) {
        this.code = code
    }

    fun getMsg(): String {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    override fun toString(): String {
        return "LazyResponse\n{" +
                "\ncode=" + code +
                ",\nmsg='" + msg + '\''.toString() +
                ",\ndata=" + data +
                "\n}"
    }
}