package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.*

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

    /* TODO:
    * Insertar Allergy
    */

    /* TODO:
    * Insertar Disease
    */

    /* TODO:
    * Insertar Medication
    */

    /* Seleccionar informacion del perro */
    @Query("SELECT * FROM Dog WHERE dog_id = :dogId")
    suspend fun getDogInfo(dogId: Int): LiveData<Dog>

    /* Seleccionar el listado de los tamaños de perros */
    @Transaction
    @Query("SELECT * FROM Size")
    fun getSize(): LiveData<List<Size>>

    /* Seleccionar el listado de baños */
    @Transaction
    @Query("SELECT * FROM Bath")
    fun getDogBath(): LiveData<List<DogWithBath>>

    /* Seleccionar el listado de caminatas */
    @Transaction
    @Query("SELECT * FROM DogWalk")
    fun getDogWalk(): LiveData<List<DogWithDogWalk>>

    /* Seleccionar los usuarios de un perro */
    @Transaction
    @Query("SELECT * FROM UserXDog")
    fun getDogUser() : LiveData<List<DogWithUserXDog>>

    /* TODO:
    * Seleccionar el listado de alergias de un perro
    */

    /* TODO:
    * Seleccionar el listado de enfermedades de un perro
    */

    /* TODO:
    * Seleccionar el listado de medicamentos de un perro
    */
}