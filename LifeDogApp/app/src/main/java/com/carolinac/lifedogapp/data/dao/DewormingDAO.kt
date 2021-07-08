package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.DewormerType
import com.carolinac.lifedogapp.data.entity.Deworming
import com.carolinac.lifedogapp.data.entity.DogWithDeworming

@Dao
interface DewormingDAO {

    /* Insertar el DewormerType */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateDewormerType(dewormerType: List<DewormerType>)

    /* Insertar Desparasitacion */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDeworming(deworming: Deworming)

    /* Seleccionar el listado del tipo de desparasitacion */
    @Query("SELECT * FROM DewormerType")
    fun getDewormerType(): LiveData<List<DewormerType>>

    /* Seleccionar el listado de desparasitacion */
    @Transaction
    @Query("SELECT * FROM Deworming")
    fun getDogWithDeworming(): LiveData<List<DogWithDeworming>>


}