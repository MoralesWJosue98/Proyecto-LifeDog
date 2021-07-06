package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.DewormerType
import com.carolinac.lifedogapp.data.entity.Deworming
import com.carolinac.lifedogapp.data.entity.DogWithDeworming
import com.carolinac.lifedogapp.data.entity.VaccineCategory

@Dao
interface DewormingDAO {

    /* TODO:
   * Insertar el DewormerType
   * Es un dato "quemado", el usuario en ningún momento puede agregarlo
   * Buscar la forma de obtener esos datos.
   * */

    /* Insertar Desparasitacion */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDeworming(deworming: Deworming)

    /* Seleccionar el listado del tipo de desparasitacion */
    @Query("SELECT * FROM DewormerType")
    fun getDewormerType() : LiveData<List<DewormerType>>

    /* Seleccionar el listado de desparasitacion */
    @Transaction
    @Query("SELECT * FROM Deworming")
    fun getDogWithDeworming(): LiveData<List<DogWithDeworming>>

}