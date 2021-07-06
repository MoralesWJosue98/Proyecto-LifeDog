package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithBath(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "bath_id"
    )
    var bath: List<Bath>
)
