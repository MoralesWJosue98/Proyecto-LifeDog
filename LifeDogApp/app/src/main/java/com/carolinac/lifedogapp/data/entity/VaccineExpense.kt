package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class VaccineExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "vaccine_id")
    var vaccineId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    @ColumnInfo(name = "category_id")
    var categoryId: Int,
    var price: BigDecimal,
    var place: String,
)
