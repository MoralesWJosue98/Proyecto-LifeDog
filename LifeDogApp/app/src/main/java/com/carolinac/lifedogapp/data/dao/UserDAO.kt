package com.carolinac.lifedogapp.data.dao

import androidx.room.*
import com.carolinac.lifedogapp.data.entity.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)

    /* Seleccionar los perros de un usuario
    @Transaction
    @Query("SELECT * FROM UserXDog")
    fun getUserDog() : LiveData<List<UserWithUserXDog>>*/
}