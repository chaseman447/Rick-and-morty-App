package com.example.rickandmorty.network

import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {
    single(named("NoAuth")) { createNoAuthHttpClient() }
}