package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithVaccineExpense(
    @Embedded
    var vaccineExpense: VaccineExpense,
    @Relation(
        entity = VaccineExpense::class,
        parentColumn = "vaccine_id",
        entityColumn = "dog_id"
    )
    var vaccineExpenseAndVaccineCategory: List<VaccineExpenseAndVaccineCategory>
)
