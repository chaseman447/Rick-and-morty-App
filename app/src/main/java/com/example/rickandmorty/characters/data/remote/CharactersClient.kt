package com.example.rickandmorty.characters.data.remote

import com.example.rickandmorty.characters.data.remote.response.Character
import com.example.rickandmorty.characters.data.remote.response.Characters
import com.example.rickandmorty.network.util.AllCharacters
import com.example.rickandmorty.network.helper.handleErrors
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

class CharactersClient : KoinComponent {
    private val client: HttpClient by inject(named("NoAuth"))

    suspend fun getCharacters(): Characters = handleErrors<Characters> {
        return@handleErrors client.get(urlString = AllCharacters)
    }

    suspend fun getCharacterById(id: String): Character = handleErrors<Character> {
        return@handleErrors client.get(urlString = AllCharacters + "/$id")
    }
}