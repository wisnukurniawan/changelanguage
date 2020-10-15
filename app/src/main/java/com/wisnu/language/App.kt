package com.wisnu.language

import android.app.Application
import android.content.Context

class App : Application() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguageContext(newBase, LANGUAGE))
    }

    override fun getApplicationContext(): Context {
        val context = super.getApplicationContext()
        return LocalizationUtil.applyLanguageApplicationContext(context, LANGUAGE)
    }

    companion object {
        var LANGUAGE = "en"
    }

}