/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/22/21, 10:24 AM
 */

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