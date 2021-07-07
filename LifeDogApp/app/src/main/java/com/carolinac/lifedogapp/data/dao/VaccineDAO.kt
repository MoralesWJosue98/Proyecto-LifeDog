package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.*

@Dao
interface VaccineDAO {

    /* Insertar el VaccineCategory */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateVaccineCategory(vaccineCategory: List<VaccineCategory>)

    /* Insertar Vaccine Expense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVaccineExpense(vaccineExpense: VaccineExpense)

    /* Insertar Vaccine */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateVaccine(vaccine: Vaccine)

    /* Seleccionar el listado de tipo de vacunas categoría */
    @Query("SELECT * FROM VaccineCategory")
    fun getVaccineCategory(): LiveData<List<VaccineCategory>>

    /* Seleccionar el listado de gastos por vacunas */
    @Transaction
    @Query("SELECT * FROM VaccineExpense")
    fun getDogWithVaccineExpense(): LiveData<List<DogWithVaccineExpense>>

    /* Seleccionar el historial de vacunas agregadas */
    @Transaction
    @Query("SELECT * FROM Vaccine")
    fun getDogWithVaccine(): LiveData<List<DogWithVaccine>>

}