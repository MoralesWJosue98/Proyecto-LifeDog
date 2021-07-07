package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class FoodExpense(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "food_id")
    var foodId: Int,
    var quantity: Float,
    var price: BigDecimal?,
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    @ColumnInfo(name = "food_category_id")
    var foodCategoryId: Int
)
