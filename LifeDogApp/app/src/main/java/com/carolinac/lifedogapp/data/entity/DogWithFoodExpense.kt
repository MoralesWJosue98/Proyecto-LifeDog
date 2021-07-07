package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1  n */
data class DogWithFoodExpense(
    @Embedded
    var foodExpense: FoodExpense,
    @Relation(
        entity = FoodExpense::class,
        parentColumn = "food_id",
        entityColumn = "dog_id"
    )
    var foodExpenseAndFoodCategory: List<FoodExpenseAndFoodCategory>
)
