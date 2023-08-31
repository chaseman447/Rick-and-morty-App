package com.example.rickandmorty.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmorty.characters.data.remote.response.Character

@Composable
fun CharacterScreen(
    character: Character
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .size(200.dp, 250.dp)
                    .clip(RoundedCornerShape(20.dp)),
                model = character.image,
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Text(text = character.name)
            Column {
                Text(text = "status: ${character.status}")
                Text(text = "species: ${character.species}")
                Text(text = "gender: ${character.gender}")
                Text(text = "origin: ${character.origin}")
                Text(text = "location: ${character.location.name}")
                Text(text = "type: ${character.type}")
            }
        }
    }
}