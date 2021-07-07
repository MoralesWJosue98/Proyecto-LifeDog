package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Haircut(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "haircut_id")
    var HaircutId: Int = 0,
    var date: Date?,
    var repeat: Int,
    var remember: Boolean,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
