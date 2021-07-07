package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DogWithMedicineExpense(
    @Embedded
    var medicineExpense: MedicineExpense,
    @Relation(
        parentColumn = "medicine_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
