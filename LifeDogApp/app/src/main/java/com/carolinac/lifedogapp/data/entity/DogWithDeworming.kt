package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithDeworming(
    @Embedded
    val deworming: Deworming,
    @Relation(
        entity = Deworming::class,
        parentColumn = "dog_id",
        entityColumn = "deworming_id"
    )
    val dogDewormerType: List<DewormingAndDewormerType>
)