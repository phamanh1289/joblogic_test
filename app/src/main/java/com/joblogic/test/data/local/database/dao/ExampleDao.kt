package com.example.data.local.database.dao

import androidx.room.*
import com.example.data.local.database.AppRoomTable
import com.example.data.local.database.entity.ExampleEntity

@Dao
interface ExampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ExampleEntity>)

    @Query("SELECT * FROM ${AppRoomTable.TABLE_EXAMPLE}")
    suspend fun getExamplesAsync(): List<ExampleEntity>?

}