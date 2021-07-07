package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DewormerType(
    @PrimaryKey
    @ColumnInfo(name = "dewormer_type_id")
    var dewormerTypeId: Int,
    var type: String
)
