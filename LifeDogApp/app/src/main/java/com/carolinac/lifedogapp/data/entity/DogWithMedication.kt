package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithMedication(
    @Embedded
    var medication: Medication,
    @Relation(
        parentColumn = "medication_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
