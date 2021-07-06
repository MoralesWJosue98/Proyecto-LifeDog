package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.AccesoriesExpense
import com.carolinac.lifedogapp.data.entity.DogWithAccesoriesExpense
import com.carolinac.lifedogapp.data.entity.DogWithMedicineExpense
import com.carolinac.lifedogapp.data.entity.MedicineExpense

@Dao
interface ExpenseDAO {

    /* Insertar MedicineExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceMedicineExpense(medicineExpense: MedicineExpense)

    /* Insertar AccesoriesExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAccesoriesExpense(accesoriesExpense: AccesoriesExpense)

    /* TODO:
    * Insertar CareExpenses
    */

    /* Seleccionar el listado del tipo de gastos de medicina */
    @Transaction
    @Query("SELECT * FROM MedicineExpense")
    fun getMedicineExpense(): LiveData<List<DogWithMedicineExpense>>

    /* Seleccionar el listado del tipo de gastos de accesorios */
    @Transaction
    @Query("SELECT * FROM AccesoriesExpense")
    fun getAccesoriesExpense(): LiveData<List<DogWithAccesoriesExpense>>

    /* TODO:
    * Seleccionar el listado de tipo de gastos por cuidados
    */

}