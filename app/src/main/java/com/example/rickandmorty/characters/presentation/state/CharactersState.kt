package com.example.rickandmorty.characters.presentation.state

import com.example.rickandmorty.characters.data.remote.response.Character

data class CharactersState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val characterList:  List<Character> = emptyList(),
)
