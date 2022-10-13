package com.joblogic.test.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joblogic.test.data.local.database.AppRoomTable

@Entity(tableName = AppRoomTable.TABLE_ITEM)
data class ItemEntity(
    val name: String,
    val price: Long,
    val quantity: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
