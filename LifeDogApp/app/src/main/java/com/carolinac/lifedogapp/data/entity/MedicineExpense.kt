package com.carolinac.lifedogapp.data.entity

import android.icu.math.BigDecimal
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MedicineExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medicine_id")
    var medicineId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var medicine: String,
    var price: BigDecimal,
    var quantity: Int
)
