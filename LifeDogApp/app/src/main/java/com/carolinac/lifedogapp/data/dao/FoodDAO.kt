package com.carolinac.lifedogapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.carolinac.lifedogapp.data.entity.Feeding
import com.carolinac.lifedogapp.data.entity.FoodExpense

@Dao
interface FoodDAO {

    /*
    * TODO:
    * Insertar el FoodCategory
    * Es un dato "quemado", el usuario en ningún momento puede agregarlo
    * Buscar la forma de obtener esos datos.
    * */

    /* Insertar FoodExpense */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateFoodExpense(foodExpense: FoodExpense)

    /* Insertar Feeding */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreFeeding(feeding: Feeding)

    /*
   * TODO:
   * Seleccionar el listado del tipo de las categorias de comida
   * */

    /*
   * TODO:
   * Seleccionar el listado de gasto de comidas
   * */

    /*
   * TODO:
   * Seleccionar el listado de alimentacion
   * */

}