package com.carolinac.lifedogapp.data.entity

import android.icu.math.BigDecimal
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CareExpenses(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "care_id")
    var careId: Int = 0,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var care: String,
    var price: BigDecimal,
    var place: String
)
