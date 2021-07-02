package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserXDog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Int,
    var userIsEditor: Boolean,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
)
