package com.mahmoud.dfont.services

import android.content.Context
import android.content.SharedPreferences
import com.mahmoud.dfont.utils.DFontKeys.DFONT_SHARED_PREFERENCES_NAME
import com.mahmoud.dfont.utils.DFontKeys.INT_DEFAULT_VALUE
import com.mahmoud.dfont.utils.DFontKeys.STRING_DEFAULT_VALUE

object DFontSharedPreferences {

    private var prefs: SharedPreferences? = null

    private val notInitializedErrorMessage: String = "DFontSharedPreferences is not initialized. " +
            "Call DFontSharedPreferences.init(...) function and send a context"

    fun init(context: Context) {
        if (prefs == null) {
            prefs = context.getSharedPreferences(DFONT_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        }
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun clear() {
        prefs?.edit()?.clear()?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun getString(key: String, defaultValue: String = STRING_DEFAULT_VALUE): String {
        return prefs?.getString(key, defaultValue)  ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun putString(key: String, value: String) {
        prefs?.edit()?.putString(key, value)?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun getInt(key: String, defaultValue: Int = INT_DEFAULT_VALUE): Int {
        return prefs?.getInt(key, defaultValue) ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun putInt(key: String, value: Int) {
        prefs?.edit()?.putInt(key, value)?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }
}