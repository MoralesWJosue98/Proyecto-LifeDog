package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a 1 */
data class MedicineAndMedicineCategory(
    @Embedded
    val medication: Medication,
    @Relation(
        parentColumn = "medication_id",
        entityColumn = "medicine_category_id"
    )
    val medicineCategory: MedicineCategory
)
