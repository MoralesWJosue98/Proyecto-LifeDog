package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.carolinac.lifedogapp.data.entity.*

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

    /* Seleccionar el listado de tipo de vacunas categoría */
    @Query("SELECT * FROM VaccineCategory")
    fun getVaccineCategory() : LiveData<List<VaccineCategory>>

    /* Seleccionar el listado de gastos por vacunas */
    @Transaction
    @Query("SELECT * FROM VaccineExpense")
    fun getDogWithVaccineExpense(): LiveData<List<DogWithVaccineExpense>>

    /* Seleccionar el historial de vacunas agregadas */
    @Transaction
    @Query("SELECT * FROM Vaccine")
    fun getDogWithVaccine(): LiveData<List<DogWithVaccine>>

}