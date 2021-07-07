package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithCareExpenses(
    @Embedded
    var careExpenses: CareExpenses,
    @Relation(
        parentColumn = "care_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
