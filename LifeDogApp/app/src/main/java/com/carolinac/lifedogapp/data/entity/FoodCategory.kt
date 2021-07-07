package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodCategory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "food_category_id")
    var foodCategoryId: Int,
    var category: String
)
