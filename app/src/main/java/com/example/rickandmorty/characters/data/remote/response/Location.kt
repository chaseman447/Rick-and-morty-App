package com.example.rickandmorty.characters.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)