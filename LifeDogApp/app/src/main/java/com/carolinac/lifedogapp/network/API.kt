package com.carolinac.lifedogapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://life-dog.herokuapp.com/"

var gson = GsonBuilder()
    .setLenient()
    .create()

private var retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

object API{
    val webservice = retrofit.create(Webservice::class.java)
}