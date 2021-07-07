package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Dog(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dog_id")
    var dogId: Int,
    var name: String,
    var breed: String,
    var female: Boolean,
    var weight: Float,
    var color: String,
    var birth: Date?,
    var sterilized: Boolean,
    @ColumnInfo(name = "size_id")
    var sizeId: Int
)