package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Feeding(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "feeding_id")
    var feedingId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var date: Date,
    var time: Time,
    var food: String
)
