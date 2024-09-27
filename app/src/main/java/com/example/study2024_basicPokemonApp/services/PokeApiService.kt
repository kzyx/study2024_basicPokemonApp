package com.example.study2024_basicPokemonApp.services

import GetAllPokemonResponse
import GetPokemonByIdResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    // Hardcode to get Gen 1 Pokemon
    @GET("/api/v2/pokemon?limit=150")
    suspend fun getAllPokemon(): GetAllPokemonResponse

    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): GetPokemonByIdResponse
}