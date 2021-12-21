package com.mahmoud.dfont.extensions

import android.view.ViewGroup
import androidx.core.view.children


/**
 * Loop over all views inside this viewGroup.
 *
 * Recursively call [ViewGroup.notifyTypefaceChanged] on all ViewGroup children.
 */
fun ViewGroup.notifyTypefaceChanged() {
    children.forEach {
        if (it is ViewGroup) {
            it.notifyTypefaceChanged()
        }
        it.notifyTypefaceChanged()
    }
}