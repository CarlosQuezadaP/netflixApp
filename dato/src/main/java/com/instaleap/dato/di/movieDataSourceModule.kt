package com.instaleap.dato.di

import com.instaleap.dato.datasource.IMovieDataSource
import com.instaleap.dato.datasource.MovieDataSource
import org.koin.dsl.module

val movieDataSourceModule = module {
    single<IMovieDataSource> { MovieDataSource(get(), get()) }
}