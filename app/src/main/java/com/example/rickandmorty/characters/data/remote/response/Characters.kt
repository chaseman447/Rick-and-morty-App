package com.example.rickandmorty.characters.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    val info: Info,
    val results: List<Character>
)