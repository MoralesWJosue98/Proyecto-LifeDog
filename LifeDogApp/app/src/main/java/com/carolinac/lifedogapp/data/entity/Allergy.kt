package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Allergy(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "allergy_id")
    var allergyId: Int = 0,
    var allergy: String,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
