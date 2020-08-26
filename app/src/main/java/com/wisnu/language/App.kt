package com.wisnu.language

import android.app.Application
import android.content.Context

class App : Application() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguage(newBase, "id"))
    }

}