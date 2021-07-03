package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserAndDog(
    @Embedded
    var user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "dog_id",
        associateBy = Junction(UserXDog::class)
    )
    var dog: List<Dog>
)

data class DogAndUser(
    @Embedded
    var dog: Dog,
    @Relation(
        parentColumn = "dog_id",
        entityColumn = "user_id",
        associateBy = Junction(UserXDog::class)
    )
    var user: List<User>
)
