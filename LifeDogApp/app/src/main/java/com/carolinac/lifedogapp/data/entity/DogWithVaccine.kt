package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithVaccine(
    @Embedded
    var vaccine: Vaccine,
    @Relation(
        entity = Vaccine::class,
        parentColumn = "vaccine_id",
        entityColumn = "dog_id"
    )
    var vaccineAndVaccineCategory: List<VaccineAndVaccineCategory>
)
