package com.example.data.local.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.database.dao.ExampleDao
import com.example.data.local.database.entity.ExampleEntity
import com.example.data.other.DataConstants.Companion.DATABASE_NAME

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun createExampleDao(): ExampleDao
}

fun createDB(application: Application) = Room.databaseBuilder(
    application,
    AppRoomDatabase::class.java, DATABASE_NAME
).fallbackToDestructiveMigration().build()

fun createExampleDao(db: AppRoomDatabase) = db.createExampleDao()
