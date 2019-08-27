package com.wisnu.language

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    applyLanguage(this, "in")
    setContentView(R.layout.activity_main)

    tv_language1.text = getString(R.string.bahasa)
    tv_language2.text = applicationContext.getString(R.string.bahasa)
  }

  private fun applyLanguage(activity: Activity, language: String) {
    val locale = Locale(language)
    Locale.setDefault(locale)
    val configuration = activity.baseContext.resources.configuration
    configuration.setLocale(locale)
    activity.baseContext.resources.updateConfiguration(configuration, activity.baseContext.resources.displayMetrics)
    activity.baseContext.applicationContext.resources.updateConfiguration(configuration, activity.baseContext.resources.displayMetrics)
  }

}