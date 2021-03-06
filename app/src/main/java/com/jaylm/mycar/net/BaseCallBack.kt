package com.jaylm.mycar.net

import android.app.Activity
import com.jaylm.mycar.BuildConfig
import com.jaylm.mycar.application.BaseApp
import com.jaylm.mycar.base.BaseActivity
import com.jaylm.mycar.util.LogUtils
import com.jaylm.mycar.util.SnackbarUtils
import com.jaylm.mycar.view.ProgressDialog
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response
import com.lzy.okgo.request.base.Request
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import org.json.JSONObject
import java.net.SocketException
import java.net.SocketTimeoutException

/**
 * Created by jaylm
 * on 2018/10/1.
 */
abstract class BaseCallBack(private val mActivity: Activity, private val mShowDialog: Boolean = false) : StringCallback() {

    private var mDialog: ProgressDialog? = null//加载进度框
    private var mRefreshLayout: SmartRefreshLayout? = null//SwipeRefreshLayout
    private var mPullDown: Boolean = false//是否下拉刷新

    /**
     * recyclerView的刷新调用
     */
    constructor(mActivity: Activity, refreshLayout: SmartRefreshLayout, isPullDown: Boolean = true) : this(mActivity) {
        this.mRefreshLayout = refreshLayout
        this.mPullDown = isPullDown
    }


    init {
        if (mShowDialog && mDialog == null) {
            //初始化加载进度框
            mDialog = ProgressDialog(mActivity)
        }
    }

    override fun onSuccess(response: Response<String>) {
        val jsonString = response.body()
        if (BuildConfig.LOG_DEBUG) {
            //打印完整返回数据
            LogUtils.showLargeLog("okgo_body", jsonString)
        }

        try {
            val jsonObject = JSONObject(jsonString)
            /*JsonObject.opt 无key值时会得到默认值,JsonObject.get无key值会出错*/
            val data = jsonObject.optString("data")
            val status = jsonObject.optInt("status")
            val error = jsonObject.optString("error")
            if (status == 1) {
                onSuccess(data)
            } else {
                onError(response)
                onFailed(status, error, data)
            }
        } catch (e: Exception) {
            if (BuildConfig.LOG_DEBUG) {
                e.printStackTrace()
                SnackbarUtils.showSnackbar(mActivity.window.decorView.rootView, "数据错误")
            }
        }
    }

    override fun onStart(request: Request<String, out Request<*, *>>?) {
        if (mShowDialog) {
            showDialog()
        }
    }

    abstract fun onSuccess(jsonString: String)


    override fun onError(response: Response<String>) {
        super.onError(response)
        val tag = if (mActivity is BaseActivity) {
            mActivity.getTag()
        } else {
            "TAG"
        }
        when {
            response.exception is SocketTimeoutException -> LogUtils.e(tag, "请求超时")
            response.exception is SocketException -> LogUtils.e(tag, "服务器异常")
            response.exception is NetException ->
                when ((response.exception as NetException).getErrorBean().getCode()) {
                    404 -> LogUtils.e(tag, "当前链接错误或不存在")
                    500 -> LogUtils.e(tag, "服务器内部错误")
                }
        }
    }

    open fun onFailed(status: Int, error: String, data: String) {
        SnackbarUtils.showSnackbar(mActivity.window.decorView.rootView, error)
    }

    override fun onFinish() {
        super.onFinish()
        if (mRefreshLayout != null) {
            if (mPullDown) {
                mRefreshLayout!!.finishRefresh()
            } else {
                mRefreshLayout!!.finishLoadMore()
            }
        }

        if (mShowDialog) {
            dismissDialog()
        }
    }


    //show
    private fun showDialog() {
        try {
            if (mDialog != null && !mDialog!!.isShowing) {
                mDialog!!.show()
            }
        } catch (e: Exception) {
        }

    }

    //dismiss
    private fun dismissDialog() {
        try {
            if (mDialog != null && mDialog!!.isShowing) {
                mDialog!!.dismiss()
            }
        } catch (e: Exception) {
        }

    }
}