package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

/* Relacion 1 a 1*/
data class DewormingAndDewormerType(
    @Embedded val deworming: Deworming,
    @Relation(
        parentColumn = "deworming_id",
        entityColumn = "dewormer_type_id"
    )
    val dewormerType: DewormerType
)
