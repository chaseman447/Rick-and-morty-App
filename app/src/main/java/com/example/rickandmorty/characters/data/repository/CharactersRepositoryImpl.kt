package com.example.rickandmorty.characters.data.repository

import com.example.rickandmorty.characters.data.remote.CharactersClient
import com.example.rickandmorty.characters.data.remote.response.Character
import com.example.rickandmorty.characters.data.remote.response.Characters
import com.example.rickandmorty.characters.domain.repository.CharactersRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharactersRepositoryImpl : CharactersRepository, KoinComponent {
    private val client by inject<CharactersClient>()

    override suspend fun getCharacters(): Result<Characters> {
        return try {
            val response = client.getCharacters()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCharacterById(id: String): Result<Character> {
        return try {
            val response = client.getCharacterById(id = id)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}