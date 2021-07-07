package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Advices(
    @PrimaryKey
    @ColumnInfo(name = "advice_id")
    var adviceId: Int,
    var sizeId: Int,
    var advice: String,
    var source: String
)
