package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Deworming(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "deworming_id")
    var dewormingId: Int,
    @ColumnInfo(name = "dog_id")
    var date: Date,
    var repeat: Int,
    var single_dose: Boolean,
    var dewormer_name: String,
    @ColumnInfo(name = "dewormer_type_id")
    var dewormerTypeId: Int
)
