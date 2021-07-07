package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DogWithUserXDog(
    @Embedded val dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "user_id"
    )
    val dogXUser: List<UserXDog>
)
