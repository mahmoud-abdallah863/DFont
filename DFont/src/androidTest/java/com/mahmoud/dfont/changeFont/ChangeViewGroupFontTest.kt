/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/27/21, 8:38 AM
 */

//package com.mahmoud.dfont.changeFont
//
//import android.content.Context
//import android.graphics.Typeface
//import android.widget.Button
//import android.widget.LinearLayout
//import android.widget.TextView
//import androidx.core.content.res.ResourcesCompat
//import androidx.core.view.children
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
//import com.mahmoud.dfont.R
//import com.mahmoud.dfont.extensions.notifyTypefaceChanged
//import com.mahmoud.dfont.services.DFontSharedPreferences
//import junit.framework.Assert.assertEquals
//import junit.framework.Assert.assertNotNull
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//
//@RunWith(AndroidJUnit4ClassRunner::class)
//class ChangeViewGroupFontTest {
//
//    private val context = ApplicationProvider.getApplicationContext<Context>()
//
//    private var viewGroup: LinearLayout? = null
//
//
//    @Before
//    fun setUp() {
//        viewGroup = LinearLayout(context).apply {
//
//            repeat(3) {
//                val textView = TextView(context).apply {
//                    text = "This is  text view $it"
//                }
//                addView(textView)
//            }
//
//            repeat(2) {
//                val button = Button(context).apply {
//                    text = "This is button $it"
//                }
//                addView(button)
//            }
//        }
//
//        DFontSharedPreferences.init(context)
//        DFontSharedPreferences.clear()
//    }
//
//    @Test
//    fun test_no_font_change() {
//        var oldTypeface: Typeface? = null
//        var newTypeface: Typeface? = null
//
//        viewGroup!!.children.forEach {
//            oldTypeface = (it as TextView).typeface
//        }
//
//        viewGroup!!.notifyTypefaceChanged()
//
//        viewGroup!!.children.forEach {
//            newTypeface = (it as TextView).typeface
//        }
//
//        assertEquals(oldTypeface, newTypeface)
//
//    }
//
//    @Test
//    fun test_font_change_to_lato() {
//        val fontResource = R.font.lato
//        val typeface = ResourcesCompat.getFont(context, fontResource)
//        DFontSharedPreferences.saveFont(fontResource)
//
//        viewGroup!!.notifyTypefaceChanged()
//
//        viewGroup!!.children.forEach {
//            val newTypeface = when(it) {
//                is TextView -> it.typeface
//                is Button -> it.typeface
//                else -> null
//            }
//
//            assertNotNull(newTypeface)
//            assertEquals(typeface, newTypeface)
//        }
//    }
//}