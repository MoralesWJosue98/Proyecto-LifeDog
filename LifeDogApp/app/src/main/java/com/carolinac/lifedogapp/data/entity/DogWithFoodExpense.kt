package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1  n */
data class DogWithFoodExpense(
    @Embedded
    var dog: Dog,
    @Relation(
        entity = FoodExpense::class,
        parentColumn = "dog_id",
        entityColumn = "food_id"
    )
    var foodExpense: List<FoodExpenseAndFoodCategory>
)
