package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithUserXDog(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "dog_id"
    )
    val userXDog: List<UserXDog>
)
