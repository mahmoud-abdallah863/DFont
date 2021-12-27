/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/27/21, 8:38 AM
 */

//package com.mahmoud.dfont.changeFont
//
//import android.content.Context
//import android.content.res.Resources
//import android.widget.Button
//import android.widget.TextView
//import androidx.core.content.res.ResourcesCompat
//import androidx.test.core.app.ApplicationProvider
//import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
//import androidx.test.platform.app.InstrumentationRegistry
//import com.mahmoud.dfont.R
//import com.mahmoud.dfont.extensions.notifyTypefaceChanged
//import com.mahmoud.dfont.services.DFontSharedPreferences
//import junit.framework.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//
//@RunWith(AndroidJUnit4ClassRunner::class)
//class ChangeViewFontTest {
//
//    private val context = ApplicationProvider.getApplicationContext<Context>().applicationContext
//
//    private var textView: TextView? = null
//    private var buttonView: Button? = null
//
//    @Before
//    fun setUp() {
//        textView = TextView(context)
//        textView?.text = "This is a text"
//
//        buttonView = Button(context)
//        buttonView?.text = "This is a button"
//
//        DFontSharedPreferences.init(context)
//        DFontSharedPreferences.clear()
//    }
//
//    @Test
//    fun test_no_font_change() {
//        val oldTextTypeface = textView!!.typeface
//        val oldButtonTypeface = buttonView!!.typeface
//
//        textView!!.notifyTypefaceChanged()
//        buttonView!!.notifyTypefaceChanged()
//
//        val newTextTypeface = textView!!.typeface
//        val newButtonTypeface = buttonView!!.typeface
//
//        assertEquals(oldTextTypeface, newTextTypeface)
//        assertEquals(oldButtonTypeface, newButtonTypeface)
//    }
//
//    @Test
//    fun test_change_text_font_to_lato() {
//        val fontResource = R.font.lato_bold_italic
//        val typeface = context.resources.getFont(fontResource) //ResourcesCompat.getFont(context, fontResource)
//        DFontSharedPreferences.saveFont(fontResource)
//
//        textView?.notifyTypefaceChanged()
//        buttonView?.notifyTypefaceChanged()
//
//        val textTypeface = textView!!.typeface
//        val buttonTypeface = buttonView!!.typeface
//
//        assertEquals(typeface, textTypeface)
//        assertEquals(typeface, buttonTypeface)
//    }
//}