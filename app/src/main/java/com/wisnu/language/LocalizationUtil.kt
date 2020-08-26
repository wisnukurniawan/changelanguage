package com.wisnu.language

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

object LocalizationUtil {

    fun applyLanguage(context: Context, language: String?): Context {
        try {
            val locale = Locale(language)
            val configuration = context.resources.configuration
            val displayMetrics = context.resources.displayMetrics

            Locale.setDefault(locale)

            return if (isAtLeastSdkVersion(Build.VERSION_CODES.JELLY_BEAN_MR1)) {
                configuration.setLocale(locale)
                context.createConfigurationContext(configuration)
            } else {
                configuration.locale = locale
                context.resources.updateConfiguration(configuration, displayMetrics)
                context
            }
        } catch (exception: Exception) {
            return context
        }
    }

    private fun isAtLeastSdkVersion(versionCode: Int): Boolean {
        return Build.VERSION.SDK_INT >= versionCode
    }

    fun updateConfigurationIfSupported(config: Configuration?, language: String?): Configuration? {
        // Configuration.getLocales is added after 24 and Configuration.locale is deprecated in 24
        if (Build.VERSION.SDK_INT >= 24) {
            if (config?.locales?.isEmpty()?.not() != false) {
                return config
            }
        } else {
            if (config?.locale != null) {
                return config
            }
        }
        val locale: Locale = Locale(language)
        if (locale != null) {
            // Configuration.setLocale is added after 17 and Configuration.locale is deprecated
            // after 24
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config?.setLocale(locale)
            } else {
                config?.locale = locale
            }
        }
        return config
    }


}
