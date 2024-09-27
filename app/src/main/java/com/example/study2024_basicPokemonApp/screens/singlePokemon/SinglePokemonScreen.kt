package com.example.study2024_basicPokemonApp.screens.singlePokemon

import PokemonType
import TypeWrapper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun SinglePokemonScreen(viewModel: SinglePokemonViewModel) {
    when {
        viewModel.isLoading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        viewModel.error != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = viewModel.error ?: "Unknown error occurred")
            }
        }
        else -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(50.dp)) {
                Text(viewModel.pokemon!!.name, fontSize = 24.sp)
                AsyncImage(
                    model = viewModel.pokemon!!.sprites.front_default,
                    contentDescription = "Loaded image",
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit
                )
                Text("Types: ${viewModel.pokemon!!.types.map(TypeWrapper::type).map(PokemonType::name)}")
            }
        }
    }
}