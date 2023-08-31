package com.example.rickandmorty.character

import com.example.rickandmorty.characters.data.remote.response.Character

data class CharacterState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val selectedCharacter: Character? = null
)
