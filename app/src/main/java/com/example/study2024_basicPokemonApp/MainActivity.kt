package com.example.study2024_basicPokemonApp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.study2024_basicPokemonApp.screens.Screens
import com.example.study2024_basicPokemonApp.screens.pokemonList.PokemonListScreen
import com.example.study2024_basicPokemonApp.screens.pokemonList.PokemonListViewModel
import com.example.study2024_basicPokemonApp.screens.singlePokemon.SinglePokemonScreen
import com.example.study2024_basicPokemonApp.screens.singlePokemon.SinglePokemonViewModel
import com.example.study2024_basicPokemonApp.ui.theme.Study2024_BasicPokemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Study2024_BasicPokemonAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val pokemonListViewModel = PokemonListViewModel(navController)

    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            PokemonListScreen(pokemonListViewModel = pokemonListViewModel)
        }
        composable(
            route = Screens.Detail.route,
            arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getInt("pokemonId") ?: 1
            SinglePokemonScreen(SinglePokemonViewModel(pokemonId))
        }
    }
}

