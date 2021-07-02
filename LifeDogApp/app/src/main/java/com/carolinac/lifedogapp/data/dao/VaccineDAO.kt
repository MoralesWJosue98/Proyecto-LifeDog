package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carolinac.lifedogapp.data.entity.Vaccine
import com.carolinac.lifedogapp.data.entity.VaccineExpense

interface VaccineDAO {

    /*
    * TODO:
    * Insertar el VaccineCategory
    * Es un dato "quemado", el usuario en ningún momento puede agregarlo
    * Buscar la forma de obtener esos datos.
    * */

    /* Insertar Vaccine Expense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVaccineExpense(vaccineExpense: VaccineExpense)

    /* Insertar Vaccine */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVaccine(vaccine: Vaccine)

    /* Seleccionar el historial de refuerzo de la vacuna */
    @Query("SELECT date, clinic FROM Vaccine WHERE dog_id = :dogId")
    suspend fun getBoosterHistory(dogId: Int): LiveData<Vaccine>

    /*
    * TODO:
    * Seleccionar el historial de vacunas agregadas
    * */

    /*
   * TODO:
   * Seleccionar el listado del tipo de gastos por vacunas
   * */

}