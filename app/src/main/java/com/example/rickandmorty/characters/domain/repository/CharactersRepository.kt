package com.example.rickandmorty.characters.domain.repository

import com.example.rickandmorty.characters.data.remote.response.Character
import com.example.rickandmorty.characters.data.remote.response.Characters


interface CharactersRepository {
    suspend fun getCharacters(): Result<Characters>

    suspend fun getCharacterById(id: String): Result<Character>
}