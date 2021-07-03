package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class VaccineAndVaccineCategory(
    @Embedded
    val vaccine: Vaccine,
    @Relation(
        parentColumn = "vaccine_id",
        entityColumn = "category_id"
    )
    val vaccineCategory: VaccineCategory
)
