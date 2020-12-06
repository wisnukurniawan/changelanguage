package com.wisnu.language

import android.app.Application
import android.content.Context
import java.util.*

class App : Application() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguageContext(newBase, Locale(LANGUAGE)))
    }

    override fun getApplicationContext(): Context {
        val context = super.getApplicationContext()
        return LocalizationUtil.applyLanguageContext(context, Locale(LANGUAGE))
    }

    companion object {
        var LANGUAGE = "en"
    }

}