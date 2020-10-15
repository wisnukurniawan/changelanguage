package com.wisnu.language

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.BaseContextWrappingDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var baseContextWrappingDelegate: AppCompatDelegate? = null

    override fun getDelegate() =
        baseContextWrappingDelegate ?: BaseContextWrappingDelegate(super.getDelegate()).apply {
            baseContextWrappingDelegate = this
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_language1.text = getString(R.string.bahasa)
        tv_language2.text = applicationContext.getString(R.string.bahasa)
        tv_language3.text = resources.getString(R.string.bahasa)

        btn_english.setOnClickListener { reloadActivity("en") }
        btn_indonesia.setOnClickListener { reloadActivity("id") }
        btn_thailand.setOnClickListener { reloadActivity("th") }
    }

    private fun reloadActivity(lang: String) {
        App.LANGUAGE = lang
        val intent = Intent(this, javaClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        }
        startActivity(intent)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguageContext(newBase, App.LANGUAGE))
    }

    override fun getApplicationContext(): Context {
        val context = super.getApplicationContext()
        return LocalizationUtil.applyLanguageApplicationContext(context, App.LANGUAGE)
    }
}