package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a 1 */
data class DogAndAccesoriesExpense(
    @Embedded
    var accesoriesExpense: AccesoriesExpense,
    @Relation(
        parentColumn = "accesorie_id",
        entityColumn = "dog_id"
    )
    var dog: List<Dog>
)
