package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys  = ["user_id", "dog_id"])
data class UserXDog(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "dog_id")
    val dogId: Int,
    @ColumnInfo(name = "user_is_editor")
    val userEditor: Boolean
)
