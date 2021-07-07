package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Disease(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "disease_id")
    var diseaseId: Int = 0,
    var disease: String,
    @ColumnInfo(name = "dog_id")
    var dogId: Int
)
