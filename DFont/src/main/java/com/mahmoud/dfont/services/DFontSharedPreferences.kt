package com.mahmoud.dfont.services

import android.content.Context
import android.content.SharedPreferences
import com.mahmoud.dfont.utils.DFontKeys.DFONT_SHARED_PREFERENCES_NAME

object DFontSharedPreferences {

    private var prefs: SharedPreferences? = null

    private val notInitializedErrorMessage: String = "DFontSharedPreferences is not initialized. " +
            "Call DFontSharedPreferences.init(...) function and send a context"

    fun init(context: Context) {
        prefs = context.getSharedPreferences(DFONT_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun getString(key: String, defaultValue: String = ""): String {
        return prefs?.getString(key, defaultValue)  ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    @Throws(UninitializedPropertyAccessException::class)
    fun putString(key: String, value: String) {
        prefs?.edit()?.putString(key, value)?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }
}