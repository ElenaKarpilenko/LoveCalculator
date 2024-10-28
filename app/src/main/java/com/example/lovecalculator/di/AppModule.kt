package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lovecalculator.data.apiservice.LoveApiService
import com.example.lovecalculator.data.pref.Pref
import com.example.lovecalculator.di.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideLoveApiService(): LoveApiService {
        return Retrofit.Builder()
            .baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoveApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): Pref {
        return Pref(
            sharedPreferences
        )
    }
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LoveDataBase {
        return Room.databaseBuilder(
            context,
            LoveDataBase::class.java,
            "app_database"
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideHistoryDao(database: LoveDataBase): LoveDao {
        return database.loveDao()
    }
}