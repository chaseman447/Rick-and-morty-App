package com.example.rickandmorty.location.presentation.state

import com.example.rickandmorty.location.data.remote.response.Location

data class LocationsState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val isFailure: Boolean = false,
    val locationList:  List<Location> = emptyList(),
)