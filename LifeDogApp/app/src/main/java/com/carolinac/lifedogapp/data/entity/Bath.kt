package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Bath(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bath_id")
    var bathId: Int,
    @ColumnInfo(name = "dog_id")
    var date: Date,
    var repeat: Int,
    var remember: Boolean
)
