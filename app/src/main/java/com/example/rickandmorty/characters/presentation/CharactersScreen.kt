package com.example.rickandmorty.characters.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.example.rickandmorty.R
import com.example.rickandmorty.characters.data.remote.response.Character
import com.example.rickandmorty.characters.presentation.state.CharactersState
import com.example.rickandmorty.navigation.Routes
import com.example.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun CharactersScreen(
    state: State<CharactersState>,
    navigateTocharacter: (String) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Icon(
            modifier = Modifier
                .size(50.dp),
            painter = painterResource(id = R.drawable.rick_and_morty_icon),
            contentDescription = "Icon",
            tint = Color(0xFF24B1C8)
        )
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .offset(y = 20.dp)
                    .zIndex(1f)
                    .clip(RoundedCornerShape(20.dp))
                    .size(200.dp),
                painter = painterResource(id = R.drawable.rick_explaining),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )

            Box {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = painterResource(id = R.drawable.coming_soon_rick_and_morty),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.BottomStart),
                    text = "Coming soon",
                    color = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(vertical = 20.dp),
                text = "Characters",
                fontSize = 25.sp
            )

            Text(
                modifier = Modifier
                    .align(Alignment.Start),
                text = "Main characters",
                fontSize = 15.sp
            )
            if (state.value.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(30.dp)
                )
            }else {
                Characters(
                    modifier = Modifier
                        .padding(vertical = 20.dp),
                    characters = state.value.characterList,
                    navigateTocharacter = {navigateTocharacter(it)}
                )
            }
        }
    }
}

@Composable
fun Characters(
    characters: List<Character>,
    modifier: Modifier = Modifier,
    navigateTocharacter: (String) -> Unit = {}
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(characters) { character ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { navigateTocharacter(character.id.toString()) }
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(200.dp, 250.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = character.image,
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = character.name,
                    fontSize = 30.sp
                )
                Text(
                    text = "${character.species},${character.status}",
                    fontSize = 15.sp
                )
            }
        }
    }
}