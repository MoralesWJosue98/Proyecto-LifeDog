package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.*

@Dao
interface DogDAO {

    /* Insertar el consejo tamaño pequeño */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdviceSmall(advices: List<Advices>)

    /* Insertar el consejo tamaño mediano */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdviceMedium(advices: List<Advices>)

    /* Insertar el consejo tamaño grande */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAdviceBig(advices: List<Advices>)

    /* Insertar el Size */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateSize(size: List<Size>)

    /* Insertar Bath */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBath(bath: Bath)

    /* Insertar Dog */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDog(dog: Dog)

    /* Insertar dogWalk */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogWalk(dogWalk: DogWalk)

    /* Insertar Allergy */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogAllergy(allergy: Allergy)

    /* Insertar Disease */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogDisease(disease: Disease)

    /* Insertar Medication */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogMedication(medication: Medication)

    /* Seleccionar informacion del perro */
    @Query("SELECT * FROM Dog WHERE dog_id = :dogId")
    fun getDogInfo(dogId: Int): LiveData<Dog>

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

    /* Seleccionar los usuarios de un perro
    @Transaction
    @Query("SELECT * FROM UserXDog")
    fun getDogUser(): LiveData<List<DogWithUserXDog>> */

    /* Seleccionar el listado de alergias de un perro */
    @Transaction
    @Query("SELECT * FROM Allergy")
    fun getDogAllergy(): LiveData<List<DogWithAllergy>>

    /* Seleccionar el listado de enfermedades de un perro */
    @Transaction
    @Query("SELECT * FROM Disease")
    fun getDogDiseases(): LiveData<List<DogWithDiseases>>

    /* Seleccionar el listado de medicamentos de un perro */
    @Transaction
    @Query("SELECT * FROM Medication")
    fun getDogMedication(): LiveData<List<DogWithMedication>>

    @Query("SELECT * FROM Advices WHERE advice_id = :randomAdviceId")
    fun getRandomAdvice(randomAdviceId: Int): LiveData<Advices>
}