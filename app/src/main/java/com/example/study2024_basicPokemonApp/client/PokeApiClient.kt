package com.example.study2024_basicPokemonApp.client

import com.example.study2024_basicPokemonApp.services.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeApiClient {
    private const val BASE_URL = "https://pokeapi.co"

    val instance: PokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiService::class.java)
    }
}