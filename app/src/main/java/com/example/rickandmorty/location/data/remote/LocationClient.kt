package com.example.rickandmorty.location.data.remote

import com.example.rickandmorty.location.data.remote.response.Location
import com.example.rickandmorty.location.data.remote.response.Locations
import com.example.rickandmorty.network.helper.handleErrors
import com.example.rickandmorty.network.util.AllLocations
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class LocationClient : KoinComponent {
    private val client: HttpClient by inject(named("NoAuth"))

    suspend fun getLocations(): Locations = handleErrors<Locations> {
        return@handleErrors client.get(urlString = AllLocations)
    }

    suspend fun getLocationById(id: String): Location = handleErrors<Location> {
        return@handleErrors client.get(urlString = "$AllLocations/$id")
    }
}