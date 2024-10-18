package com.example.lovecalculator.utis

import android.content.SharedPreferences

class Pref(private val sharedPreferences: SharedPreferences) {

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