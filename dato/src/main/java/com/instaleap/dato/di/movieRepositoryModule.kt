package com.instaleap.dato.di

import com.instaleap.dato.repository.MoviesRepository
import com.instaleap.usecases.repository.IMovieRepository
import org.koin.dsl.module

val movieRepositoryModule = module {
    single<IMovieRepository> { MoviesRepository(get()) }
}