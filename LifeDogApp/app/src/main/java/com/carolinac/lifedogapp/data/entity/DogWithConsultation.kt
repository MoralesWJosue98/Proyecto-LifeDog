package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithConsultation(
    @Embedded
    var consultation: Consultation,
    @Relation(
        parentColumn = "consultation_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
