package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Vaccine(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vaccine_id")
    var vaccineId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var date: Date,
    var time: Time,
    var clinic: String,
    var remember: Boolean,
    @ColumnInfo(name = "category_id")
    var categoryId: Int,
)
