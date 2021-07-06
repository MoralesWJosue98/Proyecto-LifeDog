package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Term(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "term_id")
    var termId: Int = 0,
    @ColumnInfo(name = "dog_id")
    var term: String,
    var date: Date,
    var repeat: Int,
    var remember: Boolean
)
