package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medicine(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medicine_id")
    var medicineId: Int = 0,
    var name: String,
    var dose: Int,
    var capacity: Int?,
    @ColumnInfo(name = "medicine_category_id")
    var medicineCategoryId: Int
)
