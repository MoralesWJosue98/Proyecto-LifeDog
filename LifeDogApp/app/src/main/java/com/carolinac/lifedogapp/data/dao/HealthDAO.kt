package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carolinac.lifedogapp.data.entity.*

@Dao
interface HealthDAO {

    /* Insertar Term */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateTerm(term: Term)

    /*
    * TODO:
    * Insertar el MedicineCategory
    * Es un dato "quemado", el usuario en ningún momento puede agregarlo
    * Buscar la forma de obtener esos datos.
    * */

    /* Insertar Medicine */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateMedicine(medicine: Medicine)

    /* Seleccionar el listado de tipo de medicinas categoría */
    @Query("SELECT * FROM MedicineCategory")
    fun getMedicineCategory(): LiveData<List<MedicineCategory>>

}