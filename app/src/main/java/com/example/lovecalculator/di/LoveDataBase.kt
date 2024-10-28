package com.example.lovecalculator.di
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator.di.room.HistoryEntity
import com.example.lovecalculator.di.room.LoveDao

@Database(entities = [HistoryEntity::class], version = 1)
abstract class LoveDataBase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}
