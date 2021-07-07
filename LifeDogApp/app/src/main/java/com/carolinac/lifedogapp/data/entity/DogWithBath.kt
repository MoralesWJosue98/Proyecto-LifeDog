package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithBath(
    @Embedded
    var bath: Bath,
    @Relation(
        parentColumn = "bath_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
