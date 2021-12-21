package com.mahmoud.dfont_app

import android.app.Application
import com.mahmoud.dfont.services.DFontSharedPreferences

class DFontApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        DFontSharedPreferences.init(applicationContext)
    }
}