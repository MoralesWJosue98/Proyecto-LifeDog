package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithVaccineExpense(
    @Embedded
    var dog: Dog,
    @Relation(
        entity = VaccineExpense::class,
        parentColumn = "dog_id",
        entityColumn = "vaccine_id"
    )
    var vaccine: List<VaccineExpenseAndVaccineCategory>
)
