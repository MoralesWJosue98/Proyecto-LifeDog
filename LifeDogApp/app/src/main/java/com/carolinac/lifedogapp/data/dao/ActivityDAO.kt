package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.*

@Dao
interface ActivityDAO {

    /* Insertar Haircut */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogHaircut(haircut: Haircut)

    /* Insertar Consultation */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateDogConsultation(consultation: Consultation)

    /* Seleccionar el listado de los haircut de un perro */
    @Transaction
    @Query("SELECT * FROM Haircut")
    fun getDogHaircut(): LiveData<List<DogWithHaircut>>

    /* Seleccionar el listado de las consultation de un perro */
    @Transaction
    @Query("SELECT * FROM Consultation")
    fun getDogConsultation(): LiveData<List<DogWithConsultation>>

}