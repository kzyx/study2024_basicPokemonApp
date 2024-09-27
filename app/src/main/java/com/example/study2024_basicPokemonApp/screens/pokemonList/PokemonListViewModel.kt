package com.example.study2024_basicPokemonApp.screens.pokemonList

import BasicPokemonInfo
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.study2024_basicPokemonApp.client.PokeApiClient
import com.example.study2024_basicPokemonApp.screens.Screens
import kotlinx.coroutines.launch


class PokemonListViewModel(private val navController: NavController) : ViewModel() {
    var pokemonList by mutableStateOf<List<BasicPokemonInfo>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    init {
        fetchPokemon()
    }

    fun onItemClickedHandler(pokemonId: Int) {
        navController.navigate(Screens.Detail.createRoute(pokemonId))
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            isLoading = true
            error = null
            try {
                val response = PokeApiClient.instance.getAllPokemon()
                pokemonList = response.results
            } catch (e: Exception) {
                error = "Failed to fetch Pokemon: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}