package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion a 1 a n*/
data class DogWithDogWalk(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "walk_id"
    )
    var dogWalk: List<DogWalk>
)
