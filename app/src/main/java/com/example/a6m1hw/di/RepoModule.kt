package com.example.a6m1hw.di

import com.example.a6m1hw.data.remote.Repository
import org.koin.dsl.module

val repoModules = module {
    single { Repository(get()) }
}