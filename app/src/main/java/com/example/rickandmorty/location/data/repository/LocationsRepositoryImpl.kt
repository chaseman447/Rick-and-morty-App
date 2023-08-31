package com.example.rickandmorty.location.data.repository

import com.example.rickandmorty.location.data.remote.LocationClient
import com.example.rickandmorty.location.data.remote.response.Location
import com.example.rickandmorty.location.data.remote.response.Locations
import com.example.rickandmorty.location.domain.repository.LocationsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LocationsRepositoryImpl : LocationsRepository, KoinComponent {
    private val client by inject<LocationClient>()

    override suspend fun getLocations(): Result<Locations> {
        return try {
            val response = client.getLocations()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getLocationById(id: String): Result<Location> {
        return try {
            val response = client.getLocationById(id =id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}