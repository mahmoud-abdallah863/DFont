package com.mahmoud.dfont.services

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.assertEquals
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4ClassRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DFontSharedPreferencesTest {

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test1_getString_throws_exception() {
        val key = "test1_getString_throws_exception_key"
        DFontSharedPreferences.getString(key, "")
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun test2_putString_throws_exception() {
        val key = "test2_putString_throws_exception_key"
        DFontSharedPreferences.putString(key, "")
    }

    @Test
    fun test3_getString_default_value() {
        val key = "test3_getString_default_value_key"
        val defaultValue = "test"

        DFontSharedPreferences.init(context)
        assertEquals(
            defaultValue,
            DFontSharedPreferences.getString(key, defaultValue),
        )
    }

    @Test
    fun test4_putString() {
        val key = "test4_putString_key"
        val value = "testing"

        DFontSharedPreferences.init(context)
        DFontSharedPreferences.putString(key, value)

        val returnedValue = DFontSharedPreferences.getString(key, "")
        assertEquals(value, returnedValue)
    }

    @Test
    fun test5_saveDataInEmptyKey() {
        val key = ""
        val value = "testing empty key"

        DFontSharedPreferences.init(context)
        DFontSharedPreferences.putString(key, value)

        val returnedValue = DFontSharedPreferences.getString(key, "")
        assertEquals(value, returnedValue)
    }

}