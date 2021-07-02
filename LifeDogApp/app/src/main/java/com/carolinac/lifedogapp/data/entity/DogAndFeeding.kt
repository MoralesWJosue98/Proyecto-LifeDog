package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DogAndFeeding(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "feeding_id"
    )
    var feeding: List<Feeding>
)
