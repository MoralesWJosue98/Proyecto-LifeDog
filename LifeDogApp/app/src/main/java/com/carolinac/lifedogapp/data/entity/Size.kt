package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Size(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "size_id")
    var sizeId: Int,
    var size: String,
)
