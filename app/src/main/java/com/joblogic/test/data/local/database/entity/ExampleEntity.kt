package com.example.data.local.database.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.database.AppRoomTable

@Entity(tableName = AppRoomTable.TABLE_EXAMPLE)
data class ExampleEntity(
    val title: String,
    val author: String,
    val thumbnail: String,
    val url: String
) {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int? = null
}
