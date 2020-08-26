package com.wisnu.language

import android.content.Context
import android.os.Build
import java.util.*

object LocalizationUtil {
    @SuppressWarnings("Deprecated in Android 17")
    fun applyLanguageContext(context: Context, language: String?): Context {
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
}
