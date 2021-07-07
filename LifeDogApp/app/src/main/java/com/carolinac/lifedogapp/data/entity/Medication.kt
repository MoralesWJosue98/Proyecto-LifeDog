package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.*

@Entity
data class Medication(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medication_id")
    var medicationId: Int = 0,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var date: Date?,
    var time: Time?,
    var repeat: Int,
    @ColumnInfo(name = "time_limit")
    var timeLimit: Int?,
    @ColumnInfo(name = "term_id")
    var termId: Int,
    @ColumnInfo(name = "time_limit_term_id")
    var timeLimitTermId: Int?,
    @ColumnInfo(name = "medicine_id")
    var medicineId: Int
)
