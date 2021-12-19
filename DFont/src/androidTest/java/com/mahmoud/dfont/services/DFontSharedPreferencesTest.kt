package com.mahmoud.dfont.services

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TYPEFACE
import com.mahmoud.dfont.utils.DFontKeys.FONT_DEFAULT_VALUE
import com.mahmoud.dfont.utils.DFontKeys.INT_DEFAULT_VALUE
import com.mahmoud.dfont.utils.DFontKeys.STRING_DEFAULT_VALUE
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DFontSharedPreferencesTest {

    val context = ApplicationProvider.getApplicationContext<Context>()

    @Before
    fun setUp() {
        DFontSharedPreferences.init(context)
        DFontSharedPreferences.clear()
    }


    @Test
    fun test_getString_no_default_value_passed() {
        val returnedValue = DFontSharedPreferences.getString("key")

        assertEquals(STRING_DEFAULT_VALUE, returnedValue)
    }

    @Test
    fun test_getString_default_value() {
        val defaultValue = "test"
        val returnedValue = DFontSharedPreferences.getString("key", defaultValue)

        assertEquals(defaultValue, returnedValue)
    }

    @Test
    fun test_putString() {
        val key = "key"
        val value = "testing"

        DFontSharedPreferences.putString(key, value)
        val returnedValue = DFontSharedPreferences.getString(key, "")

        assertEquals(value, returnedValue)
    }

    @Test
    fun test_saveDataInEmptyKey() {
        val key = ""
        val value = "testing empty key"

        DFontSharedPreferences.putString(key, value)
        val returnedValue = DFontSharedPreferences.getString(key, "")
        assertEquals(value, returnedValue)
    }

    @Test
    fun test_getInt_defaultValue() {
        val defaultValue = 0
        val returnedValue =
            DFontSharedPreferences.getInt("key", defaultValue)

        assertEquals(defaultValue, returnedValue)
    }

    @Test
    fun test_getInt_no_default_value_passes() {
        val returnedValue = DFontSharedPreferences.getInt("key")

        assertEquals(Integer.MIN_VALUE, returnedValue)
    }

    @Test
    fun test_putInt() {
        val key = "key"
        val value = 123

        DFontSharedPreferences.putInt(key, value)
        val returnedValue = DFontSharedPreferences.getInt(key, value)

        assertEquals(value, returnedValue)
    }

    @Test
    fun test_clear() {
        val key = "key"
        DFontSharedPreferences.putInt(key, 123)
        DFontSharedPreferences.clear()

        val returnedValue = DFontSharedPreferences.getInt(key)
        assertEquals(INT_DEFAULT_VALUE, returnedValue)
    }

    @Test
    fun test_saveFont() {
        val fakeFontValue = 123
        DFontSharedPreferences.saveFont(fakeFontValue)
        val fontReturned = DFontSharedPreferences.getInt(DFONT_TYPEFACE, ResourcesCompat.ID_NULL)

        assertEquals(fakeFontValue, fontReturned)
    }

    @Test
    fun test_getFont_not_sending_default_value() {
        val fontResource = DFontSharedPreferences.getFont()

        assertEquals(FONT_DEFAULT_VALUE, fontResource)
    }

    @Test
    fun test_getFont_defaultValue() {
        val fakeFontValue = 123
        val fontResourcesReturned = DFontSharedPreferences.getFont(fakeFontValue)

        assertEquals(fontResourcesReturned, fakeFontValue)
    }

    @Test
    fun test_getFont() {
        val fakeFontValue = 123
        DFontSharedPreferences.saveFont(fakeFontValue)
        val fontResourcesReturned = DFontSharedPreferences.getFont()

        assertEquals(fakeFontValue, fontResourcesReturned)
    }
}