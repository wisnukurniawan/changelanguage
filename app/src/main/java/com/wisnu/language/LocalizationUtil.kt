package com.wisnu.language

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*

object LocalizationUtil {

    fun applyLanguageContext(context: Context, language: String?): Context {
        return try {
            val locale = Locale(language)
            setupLocale(locale)
            val configuration = getOverridingConfig(locale, context.resources)
            context.createConfigurationContext(configuration)
        } catch (exception: Exception) {
            context
        }
    }

    fun applyLanguageApplicationContext(baseContext: Context, language: String?): Context {
        val configuration = baseContext.resources.configuration
        val baseLocale = getLocale(configuration)
        val currentLocale = Locale(language)

        return if (!baseLocale.toString().equals(currentLocale.toString(), ignoreCase = true)) {
            applyLanguageContext(LocalizationContext(baseContext, language), language)
        } else {
            baseContext
        }
    }

    private class LocalizationContext(base: Context, private val language: String?) : ContextWrapper(base) {

        override fun getResources(): Resources {
            val locale = Locale(language)
            val configuration = getOverridingConfig(locale, super.getResources())

            return Resources(assets, super.getResources().displayMetrics, configuration)
        }

    }

    private fun setupLocale(locale: Locale) {
        Locale.setDefault(locale)

        if (isAbove(Build.VERSION_CODES.N)) {
            LocaleList.setDefault(LocaleList(locale))
        }
    }

    private fun getOverridingConfig(locale: Locale, resources: Resources): Configuration {
        val configuration = resources.configuration

        if (isAbove(Build.VERSION_CODES.N)) {
            configuration.setLocales(LocaleList(locale))
        } else {
            configuration.setLocale(locale)
        }
        return configuration
    }

    private fun getLocale(configuration: Configuration): Locale {
        return if (isAbove(Build.VERSION_CODES.N)) {
            configuration.locales.get(0)
        } else {
            configuration.locale
        }
    }

    private fun isAbove(versionCode: Int) = Build.VERSION.SDK_INT >= versionCode

}