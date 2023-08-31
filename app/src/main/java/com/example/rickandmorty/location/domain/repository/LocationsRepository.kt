package com.example.rickandmorty.location.domain.repository

import com.example.rickandmorty.location.data.remote.response.Location
import com.example.rickandmorty.location.data.remote.response.Locations


interface LocationsRepository {
    suspend fun getLocations(): Result<Locations>

    suspend fun getLocationById(id: String): Result<Location>

}