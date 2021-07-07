package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Consultation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "consultation_id")
    var consultationId: Int = 0,
    var date: Date?,
    var time: Time?,
    var place: String,
    var veterinary: String?,
    var reason: String,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
