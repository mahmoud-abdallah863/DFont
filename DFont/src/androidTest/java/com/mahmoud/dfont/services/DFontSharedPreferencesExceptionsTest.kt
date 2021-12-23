//package com.mahmoud.dfont.services
//
//import android.util.Log
//import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
//import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import java.lang.Exception
//
//
//@RunWith(AndroidJUnit4ClassRunner::class)
//class DFontSharedPreferencesExceptionsTest {
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_clear_not_initialized_exception() {
//        DFontSharedPreferences.clear()
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_getString_not_initialized_exception() {
//        DFontSharedPreferences.getString("", "")
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_putString_not_initialized_exception() {
//        DFontSharedPreferences.putString("", "")
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_getInt_not_initialized_exception() {
//        DFontSharedPreferences.getInt("", 0)
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_putInt_not_initialized_exception() {
//        DFontSharedPreferences.putInt("", 0)
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_saveFont_not_initialized_exception() {
//        DFontSharedPreferences.saveFont(123)
//    }
//
//    @Test(expected = UninitializedPropertyAccessException::class)
//    fun test_getFont_not_initialized_exception() {
//        DFontSharedPreferences.getFont()
//    }
//}