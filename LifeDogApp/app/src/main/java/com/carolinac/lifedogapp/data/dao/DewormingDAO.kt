package com.carolinac.lifedogapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.carolinac.lifedogapp.data.entity.Deworming

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

    /*
    * TODO:
    * Seleccionar el listado del tipo de desparasitacion
    * */

    /*
   * TODO:
   * Seleccionar el listado de desparasitacion
   * */

}