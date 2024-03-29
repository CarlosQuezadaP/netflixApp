package com.instaleap.usecases.di

import com.instaleap.usecases.*
import org.koin.dsl.module

val usescase_module = module {
    single<IGetPopularMoviesUseCase> { GetPopularMoviesUseCase(get()) }
    single<IGetAllMoviesGenresUseCase> { GetAllMoviesGenresUseCase(get()) }
    single<IGetMoviesByGenreUseCase> { GetMoviesByGenreUseCase(get()) }
    single<IGetSeriesByGenreUseCase> { GetSeriesByGenreUseCase(get()) }
    single<IGetMovieDetailUseCase> { GetMovieDetailUseCase(get()) }
    single<IGetSerieDetailUseCase> { GetSerieDetailUseCase(get()) }
    single<IGetPopularSeriesUseCase> { GetPopularSeriesUseCase(get()) }
}
