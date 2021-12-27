/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/22/21, 10:24 AM
 */

package com.mahmoud.dfont.extensions

import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.mahmoud.dfont.services.ChangeableTypefaceViews
import com.mahmoud.dfont.services.DFontSharedPreferences
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG


/**
 * When this function is called,
 * - First check if the view hasTypeface using [ChangeableTypefaceViews.hasTypeface] function
 * - Get typeface from sharedPreferences using [DFontSharedPreferences.getInt] then check if it is
 *  not [ResourcesCompat.ID_NULL]
 * - Call [ChangeableTypefaceViews.changeTypeface] to change view typeface accirdingly
 *
 * @see ChangeableTypefaceViews.hasTypeface
 * @see DFontSharedPreferences.getInt,
 * @see ChangeableTypefaceViews.changeTypeface
 */
fun View.notifyTypefaceChanged() {

    if (!ChangeableTypefaceViews.hasTypeface(this)) {
        Log.d(DFONT_TAG, "notifyTypefaceChanged: ${this.javaClass.name} has no typeface.")
        return
    }

    val typeface = DFontSharedPreferences.getFont()
    if (typeface == ResourcesCompat.ID_NULL) {
        Log.d(DFONT_TAG, "No typeface stored in DFontSharedPreferences. Call " +
                "DFontSharedPreferences.saveFont(...) to save your desired font")
        return
    }

    // TODO: check if view typeface is identical to @typeface variable

    ChangeableTypefaceViews.changeTypeface(this, context, typeface)
}