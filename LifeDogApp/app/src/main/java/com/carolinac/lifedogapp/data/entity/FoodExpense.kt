package com.carolinac.lifedogapp.data.entity

import android.icu.math.BigDecimal
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "food_id")
    var foodId: Int,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var quantity: Float,
    var price: BigDecimal,
    @ColumnInfo(name = "food_category_id")
    var foodCategoryId: Int
)
