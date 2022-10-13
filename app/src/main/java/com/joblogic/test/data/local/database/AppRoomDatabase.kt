package com.joblogic.test.data.local.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joblogic.test.data.local.database.dao.ItemDao
import com.joblogic.test.data.local.database.entity.ItemEntity
import com.joblogic.test.data.other.constant.DataConstants.Companion.DATABASE_NAME

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun createItemDao(): ItemDao
}

fun createDB(application: Application) = Room.databaseBuilder(
    application,
    AppRoomDatabase::class.java, DATABASE_NAME
).fallbackToDestructiveMigration().build()

fun createItemDao(db: AppRoomDatabase) = db.createItemDao()
