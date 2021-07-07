package com.carolinac.lifedogapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val POKE_API_BASE_URL = "https://pokeapi.co/api/v2/"

private var retrofit = Retrofit.Builder()
    .baseUrl(POKE_API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

object API{
    val webservice = retrofit.create(Webservice::class.java)
}