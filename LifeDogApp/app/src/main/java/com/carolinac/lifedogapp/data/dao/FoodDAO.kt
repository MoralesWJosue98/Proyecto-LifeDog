package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.*

@Dao
interface FoodDAO {

    /* Insertar el FoodCategory */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateFoodCategory(foodCategory: List<FoodCategory>)

    /* Insertar FoodExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateFoodExpense(foodExpense: FoodExpense)

    /* Insertar Feeding */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreFeeding(feeding: Feeding)

    /* Seleccionar el listado del tipo de las categorias de comida */
    @Transaction
    @Query("SELECT * FROM FoodCategory")
    fun getFoodCategory(): LiveData<List<FoodCategory>>

    /* Seleccionar el listado de gasto de comidas */
    @Transaction
    @Query("SELECT * FROM FoodExpense")
    fun getFoodExpense(): LiveData<List<DogWithFoodExpense>>
}