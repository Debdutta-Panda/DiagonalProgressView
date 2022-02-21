package com.learnpea.diagonalprogressview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class DiagonalProgressView : View {
    var progress: Int = 50
    set(value){
        if(value<0){
            field = 0
        }
        if(value>100){
            field = 100
        }
        invalidate()
    }
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    val paint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 4f
        strokeCap = Paint.Cap.ROUND
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val x1 = 0f
        val y1 = height.toFloat()
        val x2 = (width*progress/100f)
        val y2 = height*(100-progress)/100f
        canvas?.drawLine(x1,y1,x2,y2,paint)
    }
}