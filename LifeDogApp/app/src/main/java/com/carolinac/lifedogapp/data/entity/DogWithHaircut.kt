package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithHaircut(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "haircut_id"
    )
    var haircut: List<Haircut>
)
