package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DogAndSize(
    @Embedded
    val dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "size_id"
    )
    val size: Size
)
