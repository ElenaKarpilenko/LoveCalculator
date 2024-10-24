package com.example.lovecalculator.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lovecalculator.R
import com.example.lovecalculator.data.pref.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    @Inject
    lateinit var sharedPreferences: Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        if (!sharedPreferences.isOnboardingComplete()) {
            sharedPreferences.setOnboardingComplete(true)
        } else {
            navController.navigate(R.id.startFragment)
        }
    }
}
