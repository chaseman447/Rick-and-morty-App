package com.example.rickandmorty.character

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmorty.characters.data.remote.response.Character

@Composable
fun CharacterScreen(
    state: State<CharacterState>
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF34B9CD)
    ) {
        if (state.value.isLoading){
            CircularProgressIndicator()
        } else {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp, 250.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = state.value.selectedCharacter.image,
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(20.dp),
                    text = state.value.selectedCharacter.name,
                    fontSize = 30.sp,
                    color = Color.Yellow
                )
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .border(
                            width = 5.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        ),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(
                            top = 10.dp,
                            start = 30.dp
                        ),
                        text = "status: ${state.value.selectedCharacter.status}",
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        text = "species: ${state.value.selectedCharacter.species}",
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        text = "gender: ${state.value.selectedCharacter.gender}",
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        text = "origin: ${state.value.selectedCharacter.origin.name}",
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        text = "location: ${state.value.selectedCharacter.location.name}",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}