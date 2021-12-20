package com.mahmoud.dfont.extensions

import android.view.ViewGroup
import androidx.core.view.allViews


/**
 * Loop over all views inside this viewGroup.
 *
 * Recursively call [ViewGroup.notifyTypefaceChanged] on all ViewGroup childrens.
 */
fun ViewGroup.notifyTypefaceChanged() {
    allViews.forEach {
        if (it is ViewGroup) {
            it.notifyTypefaceChanged()
        }
        it.notifyTypefaceChanged()
    }
}