package com.carolinac.lifedogapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.carolinac.lifedogapp.data.entity.User
import com.carolinac.lifedogapp.data.entity.UserWithUserXDog

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: User)

    /* Seleccionar los perros de un usuario */
    @Transaction
    @Query("SELECT * FROM Dog")
    fun getUserDog(): LiveData<List<UserWithUserXDog>>
}