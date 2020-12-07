package com.wisnu.language

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_language1.text = getString(R.string.bahasa)
        tv_language2.text = applicationContext.getString(R.string.bahasa)
        tv_language3.text = resources.getString(R.string.bahasa)

        btn_english.setOnClickListener { reloadActivity("en") }
        btn_indonesia.setOnClickListener { reloadActivity("id") }
        btn_thailand.setOnClickListener { reloadActivity("th") }

        launch.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun reloadActivity(lang: String) {
        App.LANGUAGE = lang
        val intent = Intent(this, javaClass).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        }
        startActivity(intent)
    }

    override fun getBaseContext(): Context {
        return LocalizationUtil.applyLanguageContext(super.getBaseContext(), Locale(App.LANGUAGE))
    }

    override fun getApplicationContext(): Context {
        val context = super.getApplicationContext()
        return LocalizationUtil.applyLanguageContext(context, Locale(App.LANGUAGE))
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalizationUtil.applyLanguageContext(newBase, Locale(App.LANGUAGE)))
    }
}