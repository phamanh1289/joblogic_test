package com.joblogic.test.data.local.database.dao

import androidx.room.*
import com.joblogic.test.data.local.database.AppRoomTable
import com.joblogic.test.data.local.database.entity.ItemEntity

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<ItemEntity>)

    @Query("SELECT * FROM ${AppRoomTable.TABLE_ITEM_TO_SELL}")
    suspend fun getItems(): List<ItemEntity>?

}