package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithHaircut(
    @Embedded
    var haircut: Haircut,
    @Relation(
        parentColumn = "haircut_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
