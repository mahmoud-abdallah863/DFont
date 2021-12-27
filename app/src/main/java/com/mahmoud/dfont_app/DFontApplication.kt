/*
 *
 * Created by mahmoud on 12/27/21, 11:33 PM
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 12/22/21, 9:02 PM
 */

package com.mahmoud.dfont_app

import android.app.Application
import com.mahmoud.dfont.services.DFontSharedPreferences

class DFontApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        DFontSharedPreferences.init(applicationContext)
    }
}