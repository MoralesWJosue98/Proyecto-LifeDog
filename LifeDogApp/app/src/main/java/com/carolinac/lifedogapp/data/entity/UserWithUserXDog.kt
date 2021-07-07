package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithUserXDog(
    @Embedded val dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "user_id",
        associateBy = Junction(UserXDog::class)
    )
    val user: List<User>
)
