package com.jaylm.mycar.util

import android.support.annotation.ColorRes
import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.jaylm.mycar.R
import java.lang.ref.WeakReference

/**
 * Created by ${jaylm}
 * on 2017/12/31.
 */
object SnackbarUtils {

    private var snackbarWeakReference: WeakReference<Snackbar>? = null


    /**
     * 设置snackbar文字和背景颜色
     *
     * @param  parent 父视图(CoordinatorLayout或者DecorView)
     * @param  text 文本
     *
     * @param  textColor 文本颜色
     * @param  bgColor 背景色
     *
     * @param  actionText 事件文本
     * @param  actionTextColor 事件文本颜色
     * @param  listener 监听器
     *
     * @param  duration 显示时长
     */
    fun showSnackbar(parent: View, text: CharSequence, @ColorRes textColor: Int = R.color.c2,
                     @ColorRes bgColor: Int = R.color.snackbar_bg, actionText: CharSequence = "",
                     @ColorRes actionTextColor: Int = R.color.colorPrimaryDark, listener: View.OnClickListener? = null,
                     duration: Int = Snackbar.LENGTH_SHORT) {

        snackbarWeakReference = WeakReference(Snackbar.make(parent, text, duration))
        val snackbar = snackbarWeakReference?.get()
        if (snackbar != null) {
            val view = snackbar.view
            val textView = view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
            textView.setTextColor(snackbar.context.resources.getColor(textColor))
            textView.textSize = 15f
            textView.setSingleLine()
            textView.ellipsize = TextUtils.TruncateAt.END
            view.setBackgroundColor(snackbar.context.resources.getColor(bgColor))
            if (actionText.isNotEmpty() && listener != null) {
                snackbar.setActionTextColor(snackbar.context.resources.getColor(actionTextColor))
                snackbar.setAction(actionText, listener)
            }
            snackbar.duration = duration
            snackbar.show()
        }
    }

    /**
     * 为snackbar添加布局
     * <p>在show...Snackbar之后调用</p>
     *
     * @param layoutId 布局文件
     * @param index    位置(the position at which to add the child or -1 to add last)
     */

    fun addView(@LayoutRes layoutId: Int, index: Int) {
        val snackbar = snackbarWeakReference?.get()
        if (snackbar != null) {
            val view = snackbar.view
            val layout = view as Snackbar.SnackbarLayout
            val child = LayoutInflater.from(view.getContext()).inflate(layoutId, null)
            val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.CENTER_VERTICAL
            layout.addView(child, index, params)
        }
    }

    /**
     * 取消snackbar显示
     */
    fun dismissSnackbar() {
        if (snackbarWeakReference != null && snackbarWeakReference!!.get() != null) {
            snackbarWeakReference!!.get()!!.dismiss()
            snackbarWeakReference = null
        }
    }
}