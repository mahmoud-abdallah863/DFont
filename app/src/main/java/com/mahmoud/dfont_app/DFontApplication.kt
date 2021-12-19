package com.mahmoud.dfont_app

import android.app.Application
import com.mahmoud.dfont.services.DFontSharedPreferences
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TYPEFACE

class DFontApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        DFontSharedPreferences.init(applicationContext)
        DFontSharedPreferences.putInt(DFONT_TYPEFACE, R.font.lato_bold)
    }
}