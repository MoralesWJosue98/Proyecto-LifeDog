package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carolinac.lifedogapp.data.entity.Bath
import com.carolinac.lifedogapp.data.entity.Dog
import com.carolinac.lifedogapp.data.entity.DogWalk

@Dao
interface DogDAO {

    /*TODO:
    * Insertar el Size
    * Es un dato "quemado", el usuario en ningún momento puede agregarlo
    * Buscar la forma de obtener esos datos.
    * */

    /* Insertar Bath */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBath(bath: Bath)

    /* Insertar Dog */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDog(dog: Dog)

    /* Insertar dogWalk */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogWalk(dogWalk: DogWalk)

    /* Seleccionar informacion del perro */
    @Query("SELECT * FROM Dog WHERE dog_id = :dogId")
    suspend fun getDogInfo(dogId: Int): LiveData<Dog>

    /*
   * TODO:
   * Seleccionar el listado de los tamaños de perros
   * */

    /*
   * TODO:
   * Seleccionar el listado de baños
   * */

    /*
   * TODO:
   * Seleccionar el listado de caminatas
   * */

}