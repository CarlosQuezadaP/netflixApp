package com.instaleap.dato.di

import com.instaleap.dato.datasource.MovieDataSource
import org.koin.dsl.module

val movieDataSourceModule = module {
    single { MovieDataSource(get(), get()) }
}