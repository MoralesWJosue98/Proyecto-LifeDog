package com.carolinac.lifedogapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MedicineCategory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medicine_category_id")
    var medicineCategoryId: Int = 0,
    var category: String
)
