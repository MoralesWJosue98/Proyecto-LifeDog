package com.carolinac.lifedogapp.data.entity

import androidx.room.TypeConverter
import java.math.BigDecimal

class PriceConverters {

    /* Convertir de Long a BigDecimal */
    @TypeConverter
    fun bigDecimalFromLong(value: Long?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    /* Convertr de BigDecimal a Long */
    @TypeConverter
    fun bigDecimalToLong(bigDecimal: BigDecimal?): Long? {
        return bigDecimal?.toLong()
    }

}