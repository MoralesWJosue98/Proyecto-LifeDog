package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys  = ["user_id", "dog_id"])
data class UserXDog(
    val userId: Int,
    val dogId: Int,
    @ColumnInfo(name = "user_is_editor")
    val userEditor: Boolean
)
