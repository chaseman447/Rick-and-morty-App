package com.example.rickandmorty.character

import com.example.rickandmorty.characters.data.remote.response.Character
import com.example.rickandmorty.characters.data.remote.response.Location
import com.example.rickandmorty.characters.data.remote.response.Origin

data class CharacterState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val selectedCharacter: Character = Character(
        created = "",
        episode = listOf(""),
        gender = "",
        id = 0,
        image = "",
        location = Location(name = "", url = ""),
        name = "",
        origin = Origin(name = "", url = ""),
        species = "",
        status = "",
        type = "",
        url = ""
    )
)
