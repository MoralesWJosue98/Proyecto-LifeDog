package com.carolinac.lifedogapp.data.entity

import androidx.room.TypeConverter
import java.sql.Time
import java.util.*

class Converters {

    /* Convertir de Long a Date */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    /* Convertir de Date a Long */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    /* Convertir de Long a Time */
    @TypeConverter
    fun fromTime(value: Long?): Time? {
        return value?.let { Time(it) }
    }

    /* Convertir de Time a Long */
    @TypeConverter
    fun timeToLong(time: Time?): Long? {
        return time?.time?.toLong()
    }

}