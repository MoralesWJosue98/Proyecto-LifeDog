package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FoodExpenseAndFoodCategory(
    @Embedded
    val foodExpense: FoodExpense,
    @Relation(
        parentColumn = "food_id",
        entityColumn = "food_category_id"
    )
    val foodCategory: FoodCategory
)
