package com.example.study2024_basicPokemonApp.screens.singlePokemon

import GetPokemonByIdResponse
import Sprites
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.study2024_basicPokemonApp.client.PokeApiClient
import kotlinx.coroutines.launch

class SinglePokemonViewModel(private val pokemonId: Int): ViewModel() {
    var pokemon by mutableStateOf<GetPokemonByIdResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                pokemon = PokeApiClient.instance.getPokemonById(pokemonId)
            } catch (e: Exception) {
                error = "Failed to fetch Pokemon: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}