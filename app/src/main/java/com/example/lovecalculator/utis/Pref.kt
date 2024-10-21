package com.example.lovecalculator.utis

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val SHOWN = "shown"
    }

    fun isOnboardingComplete(): Boolean {
        return sharedPreferences.getBoolean(SHOWN, false)
    }

    fun setOnboardingComplete(b: Boolean) {
        sharedPreferences.edit().putBoolean(SHOWN, true).apply()
    }
}