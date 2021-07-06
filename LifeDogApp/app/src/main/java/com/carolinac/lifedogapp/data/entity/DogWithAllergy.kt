package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithAllergy(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "allergy_id"
    )
    var allergy: List<Allergy>
)
