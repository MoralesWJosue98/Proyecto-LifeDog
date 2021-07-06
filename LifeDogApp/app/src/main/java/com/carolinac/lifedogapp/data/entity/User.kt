package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Int,
    var username: String,
    var password: String,
    var code: Int,
    var email: String
)
