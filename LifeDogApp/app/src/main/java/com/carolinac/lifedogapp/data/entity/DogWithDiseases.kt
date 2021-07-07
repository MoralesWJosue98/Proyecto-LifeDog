package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a n */
data class DogWithDiseases(
    @Embedded
    var disease: Disease,
    @Relation(
        parentColumn = "disease_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
