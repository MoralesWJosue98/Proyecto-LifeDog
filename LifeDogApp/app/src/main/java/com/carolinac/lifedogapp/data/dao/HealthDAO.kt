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

    /* Insertar el MedicineCategory */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateMedicineCategory(medicineCategory: List<MedicineCategory>)

    /* Insertar Medicine */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateMedicine(medicine: Medicine)

    /* Seleccionar el listado de tipo de medicinas categoría */
    @Query("SELECT * FROM MedicineCategory")
    fun getMedicineCategory(): LiveData<List<MedicineCategory>>

}