package com.example.rickandmorty.location.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)