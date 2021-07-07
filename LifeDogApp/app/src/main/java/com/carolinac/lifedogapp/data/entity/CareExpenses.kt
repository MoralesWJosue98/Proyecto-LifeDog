package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class CareExpenses(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "care_id")
    var careId: Int = 0,
    var care: String,
    var price: BigDecimal?,
    var place: String,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
