package com.jaylm.mycar.view

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.ColorRes
import android.support.v7.widget.RecyclerView
import android.view.View
import com.jaylm.mycar.R
import com.jaylm.mycar.application.BaseApp
import com.jaylm.mycar.util.SizeUtils

/**
 * Created by jaylm
 * on 2018/10/3.
 */
class DecorationLinearDivider(@ColorRes var color: Int = R.color.c10, val height: Float = 1F, private val showLastLine: Boolean = true) : RecyclerView.ItemDecoration() {
    private var dividerHeight: Int
    private var dividerPaint: Paint

    init {
        val context = BaseApp.getInstance()
        dividerPaint = Paint()
        dividerPaint.color = context.resources.getColor(color)
        dividerHeight = SizeUtils.dp2px(context, height)
    }


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = dividerHeight
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        var childCount = parent.childCount
        if (!showLastLine) {
            childCount--
        }
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        var firstPosition = 0
        while (firstPosition < childCount) {
            val view = parent.getChildAt(firstPosition)
            val bottom = (view.bottom + dividerHeight).toFloat()
            c.drawRect(left.toFloat(), view.bottom.toFloat(), right.toFloat(), bottom, dividerPaint)
            firstPosition++
        }
    }
}