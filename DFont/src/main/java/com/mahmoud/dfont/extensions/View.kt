package com.mahmoud.dfont.extensions

import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.mahmoud.dfont.services.ChangeableTypefaceViews
import com.mahmoud.dfont.services.DFontSharedPreferences
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TYPEFACE


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

    if (!ChangeableTypefaceViews.hasTypeface(this)) { return }

    val typeface = DFontSharedPreferences.getInt(DFONT_TYPEFACE, ResourcesCompat.ID_NULL)
    if (typeface == ResourcesCompat.ID_NULL) {
        Log.d(DFONT_TAG, "No typeface stored in DFontSharedPreferences")
        return
    }

    // TODO: check if view typeface is identical to @typeface variable

    ChangeableTypefaceViews.changeTypeface(this, context, typeface)
}