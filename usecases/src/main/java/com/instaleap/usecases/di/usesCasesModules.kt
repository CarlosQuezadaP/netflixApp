package com.instaleap.usecases.di

import com.instaleap.usecases.*
import org.koin.dsl.module

val usescase_module = module {
    single<IGetAllModelsSections> { GetAllModelsSectionsUseCase(get()) }
    single<IGetMoviesGenres> { GetAllMoviesGenres(get()) }
    single<IGetMoviesByGenre> { GetMoviesByGenreUseCase(get()) }
    single<IGetTvsByGenre> { GetTvsByGenreUseCase(get()) }
    single<IGetMovieDetail> { GetMovieDetailUseCase(get()) }
}
