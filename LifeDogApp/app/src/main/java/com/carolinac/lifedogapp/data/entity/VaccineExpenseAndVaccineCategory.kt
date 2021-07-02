package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class VaccineExpenseAndVaccineCategory(
    @Embedded
    val vaccineExpense: VaccineExpense,
    @Relation(
        parentColumn = "vaccine_id",
        entityColumn = "category_id"
    )
    val vaccineCategory: VaccineCategory
)
