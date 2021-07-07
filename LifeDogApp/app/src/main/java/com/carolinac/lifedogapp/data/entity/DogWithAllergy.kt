package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithAllergy(
    @Embedded
    var allergy: Allergy,
    @Relation(
        parentColumn = "allergy_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
