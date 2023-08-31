package com.example.rickandmorty.characters.di

import com.example.rickandmorty.characters.data.remote.CharactersClient
import com.example.rickandmorty.characters.data.repository.CharactersRepositoryImpl
import com.example.rickandmorty.characters.domain.repository.CharactersRepository
import org.koin.dsl.module

val charactersModule = module {
    single { CharactersClient() }
    single<CharactersRepository> { CharactersRepositoryImpl() }
}