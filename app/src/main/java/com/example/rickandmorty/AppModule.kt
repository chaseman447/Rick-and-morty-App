package com.example.rickandmorty

import com.example.rickandmorty.characters.di.charactersModule
import com.example.rickandmorty.location.di.locationModule
import com.example.rickandmorty.network.networkModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration) = run {
    startKoin {
        appDeclaration()
        modules(
            charactersModule,
            networkModule,
            locationModule
        )
    }
}