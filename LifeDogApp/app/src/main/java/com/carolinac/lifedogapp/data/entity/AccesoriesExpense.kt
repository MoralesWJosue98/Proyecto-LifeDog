package com.carolinac.lifedogapp.data.entity

import android.icu.math.BigDecimal
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AccesoriesExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "accesorie_id")
    var accesorieId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var accesorie: String,
    var price: BigDecimal,
    var quantity: Int
)
