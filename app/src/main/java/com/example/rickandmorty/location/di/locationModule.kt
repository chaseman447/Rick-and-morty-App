package com.example.rickandmorty.location.di

import com.example.rickandmorty.location.data.remote.LocationClient
import com.example.rickandmorty.location.data.repository.LocationsRepositoryImpl
import com.example.rickandmorty.location.domain.repository.LocationsRepository
import org.koin.dsl.module

val locationModule = module {
    single { LocationClient() }
    single<LocationsRepository> { LocationsRepositoryImpl() }
}