package com.wisnu.language

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.BaseContextWrappingDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var baseContextWrappingDelegate: AppCompatDelegate? = null

    override fun getDelegate() = baseContextWrappingDelegate ?: BaseContextWrappingDelegate(super.getDelegate()).apply {
        baseContextWrappingDelegate = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_language1.text = getString(R.string.bahasa)
        tv_language2.text = applicationContext.getString(R.string.bahasa)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguageContext(newBase, App.LANGUAGE))
    }
}