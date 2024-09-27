package com.example.study2024_basicPokemonApp.screens

sealed class Screens(val route: String) {
    data object Home : Screens("home")
    data object Detail : Screens("detail/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "detail/$pokemonId"
    }
}