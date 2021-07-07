package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion a 1 a n*/
data class DogWithDogWalk(
    @Embedded
    var dogWalk: DogWalk,
    @Relation(
        parentColumn = "walk_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
