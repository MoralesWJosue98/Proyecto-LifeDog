package com.carolinac.lifedogapp.network

import com.carolinac.lifedogapp.data.entity.User
import retrofit2.http.*

interface Webservice {
    @POST("api/user/login")
    suspend fun login(@Body user : User) : String
}