package com.joblogic.test.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joblogic.test.data.local.database.AppRoomTable

@Entity(tableName = AppRoomTable.TABLE_ITEM_TO_SELL)
data class ItemEntity(
    @field:PrimaryKey(autoGenerate = true)
    var id: Int,
    val name: String,
    val price: Long,
    val quantity: Int,
    val type: Int,
)
