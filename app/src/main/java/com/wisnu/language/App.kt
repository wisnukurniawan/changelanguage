package com.wisnu.language

import android.app.Application
import android.content.Context

class App : Application() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        LocalizationUtil.updateConfigurationIfSupported(null, LANGUAGE)
    }

    companion object {
        const val LANGUAGE = "th"
    }

}