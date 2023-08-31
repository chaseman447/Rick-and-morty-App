package com.example.rickandmorty.characters.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String
)