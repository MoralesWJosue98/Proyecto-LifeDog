package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a 1 */
data class VaccineAndVaccineCategory(
    @Embedded
    val vaccine: Vaccine,
    @Relation(
        parentColumn = "vaccine_id",
        entityColumn = "category_id"
    )
    val vaccineCategory: VaccineCategory
)
