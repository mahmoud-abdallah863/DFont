package com.mahmoud.dfont.services

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DFontSharedPreferencesExceptionsTest {

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test_clear_not_initialized_exception() {
        DFontSharedPreferences.clear()
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test_getString_not_initialized_exception() {
        DFontSharedPreferences.getString("", "")
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test_putString_not_initialized_exception() {
        DFontSharedPreferences.putString("", "")
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test_getInt_not_initialized_exception() {
        DFontSharedPreferences.getInt("", 0)
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test_putInt_not_initialized_exception() {
        DFontSharedPreferences.putInt("", 0)
    }

    /**
     * TODO: add test for [DFontSharedPreferences.saveFont] function
     */
    fun test_saveFont_not_initialized_exception() {

    }
}