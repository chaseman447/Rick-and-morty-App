package com.example.rickandmorty.location.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class Locations(
    val info: Info,
    val results: List<Location>
)