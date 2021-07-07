package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class MedicineExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medicine_id")
    var medicineId: Int,
    var medicine: String,
    var price: BigDecimal?,
    var quantity: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
