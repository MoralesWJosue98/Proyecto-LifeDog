package com.carolinac.lifedogapp.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DewormingAndDewormerType(
    @Embedded
    val deworming: Deworming,
    @Relation(
        parentColumn = "deworming_id",
        entityColumn = "dewormer_type_id"
    )
    val dewormerType: DewormerType
)
