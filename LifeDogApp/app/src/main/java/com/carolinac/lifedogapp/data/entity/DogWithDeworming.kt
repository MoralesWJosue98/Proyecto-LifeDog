package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithDeworming(
    @Embedded val dog: Dog,
    @Relation(
        entity = Deworming::class,
        parentColumn = "dog_id",
        entityColumn = "deworming_id"
    )
    val deworming: List<DewormingWithDewormerType>
)