package com.example.lovecalculator

import android.app.Application
import com.example.lovecalculator.data.api_servoce.LoveApiService
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@HiltAndroidApp
class App : Application() {

}