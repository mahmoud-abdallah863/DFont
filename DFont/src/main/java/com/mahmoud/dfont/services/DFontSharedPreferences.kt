package com.mahmoud.dfont.services

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.mahmoud.dfont.utils.DFontKeys.DFONT_SHARED_PREFERENCES_NAME
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG
import com.mahmoud.dfont.utils.DFontKeys.INT_DEFAULT_VALUE
import com.mahmoud.dfont.utils.DFontKeys.STRING_DEFAULT_VALUE


/**
 * Preferably init this object in your [Application] class. Then you can use it in your app
 *
 * This object needed to be initialized, to use it's functions. And for changing text typeface
 * to work
 *
 * @throws UninitializedPropertyAccessException will be thrown if you try to use any of this object
 *  functions, other than [init] function.
 */

object DFontSharedPreferences {

    private var prefs: SharedPreferences? = null

    private val notInitializedErrorMessage: String = "DFontSharedPreferences is not initialized. " +
            "Call DFontSharedPreferences.init(...) function and send a context"



    /**
     * Preferably, call this function from your [Application] class.
     *
     * This object need to be initialized in order to use the functions inside, and for changing
     * text typeface to work
     */
    fun init(context: Context) {
        if (prefs == null) {
            prefs = context.getSharedPreferences(DFONT_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
        }else {
            Log.d(DFONT_TAG, "DFontSharedPreferences init(): prefs is already define. " +
                    "You can't re-define prefs variable")
        }
    }

    /**
     * @throws UninitializedPropertyAccessException If prefs variable has not been initialized.
     * @see DFontSharedPreferences
     */
    @Throws(UninitializedPropertyAccessException::class)
    fun clear() {
        prefs?.edit()?.clear()?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }


    /**
     * @param[key] key that you want to get string from
     * @param[defaultValue] by default, it is equal to [STRING_DEFAULT_VALUE]
     * @return if [prefs] has [key] it will return the value stored, otherwise [defaultValue] will be returned
     * @throws UninitializedPropertyAccessException If prefs variable has not been initialized.
     * @see DFontSharedPreferences
     */
    @Throws(UninitializedPropertyAccessException::class)
    fun getString(key: String, defaultValue: String = STRING_DEFAULT_VALUE): String {
        return prefs?.getString(key, defaultValue)  ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    /**
     * @throws UninitializedPropertyAccessException If prefs variable has not been initialized.
     * @see DFontSharedPreferences
     */
    @Throws(UninitializedPropertyAccessException::class)
    fun putString(key: String, value: String) {
        prefs?.edit()?.putString(key, value)?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    /**
     * @param[key] key that you want to get string from
     * @param[defaultValue] by default, it is equal to [INT_DEFAULT_VALUE]
     * @return if [prefs] has [key] it will return the value stored, otherwise [defaultValue] will be returned
     * @throws UninitializedPropertyAccessException If prefs variable has not been initialized.
     * @see DFontSharedPreferences
     */
    @Throws(UninitializedPropertyAccessException::class)
    fun getInt(key: String, defaultValue: Int = INT_DEFAULT_VALUE): Int {
        return prefs?.getInt(key, defaultValue) ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }

    /**
     * @throws UninitializedPropertyAccessException If prefs variable has not been initialized.
     * @see DFontSharedPreferences
     */
    @Throws(UninitializedPropertyAccessException::class)
    fun putInt(key: String, value: Int) {
        prefs?.edit()?.putInt(key, value)?.apply() ?:
        throw UninitializedPropertyAccessException(notInitializedErrorMessage)
    }
}