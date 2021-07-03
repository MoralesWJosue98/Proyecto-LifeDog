package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class DogWalk(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "walk_id")
    var walkId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var date: Date,
    var time: Time,
    var place: String,
)
