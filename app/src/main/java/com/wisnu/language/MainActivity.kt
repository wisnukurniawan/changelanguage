package com.wisnu.language

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_language1.text = getString(R.string.bahasa)
        tv_language2.text = applicationContext.getString(R.string.bahasa)
    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguage(newBase, "th"))
//        super.attachBaseContext(LocalizationUtil.applyLanguage(newBase, "id"))
    }
}