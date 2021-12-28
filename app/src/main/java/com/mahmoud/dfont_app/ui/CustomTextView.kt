/*
 *
 * Created by mahmoud on 12/28/21, 11:39 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/28/21, 11:39 PM
 */

package com.mahmoud.dfont_app.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat

class CustomTextView(
    context: Context,
    attrs: AttributeSet
): View(context, attrs) {

    var text: String = "Hello World!"

    private var textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        textSize = 50f
        color = Color.GRAY
        textAlign = Paint.Align.CENTER
    }

    fun setFontResource(fontResource: Int) {
        if (fontResource != ResourcesCompat.ID_NULL) {
            textPaint.typeface = ResourcesCompat.getFont(context, fontResource)
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawText(text, width*0.5f, height*0.5f, textPaint)
    }

}