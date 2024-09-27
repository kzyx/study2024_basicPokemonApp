package com.example.study2024_basicPokemonApp.screens.pokemonList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PokemonListScreen(pokemonListViewModel: PokemonListViewModel) {
    when {
        pokemonListViewModel.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        pokemonListViewModel.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = pokemonListViewModel.error ?: "Unknown error occurred")
            }
        }
        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
            ) {
                items(pokemonListViewModel.pokemonList.size) { index ->
                    // Must add 1 since list is 0-indexed and pokemon are 1-indexed
                    Button(onClick = {pokemonListViewModel.onItemClickedHandler(index + 1)}) {
                        Text(
                            text = pokemonListViewModel.pokemonList[index].name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            fontSize = 24.sp,
                        )
                    }
                }
            }
        }
    }
}

