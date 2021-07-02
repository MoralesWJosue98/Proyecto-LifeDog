package com.carolinac.lifedogapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.carolinac.lifedogapp.data.entity.AccesoriesExpense
import com.carolinac.lifedogapp.data.entity.MedicineExpense

@Dao
interface ExpenseDAO {

    /* Insertar MedicineExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceMedicineExpense(medicineExpense: MedicineExpense)

    /* Insertar AccesoriesExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplaceAccesoriesExpense(accesoriesExpense: AccesoriesExpense)

    /*
   * TODO:
   * Seleccionar el listado del tipo de gastos de medicina
   * */

    /*
   * TODO:
   * Seleccionar el listado del tipo de gastos de accesorios
   * */

}