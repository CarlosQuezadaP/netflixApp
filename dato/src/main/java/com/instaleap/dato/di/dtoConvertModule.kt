package com.instaleap.dato.di

import com.instaleap.dato.anticorruption.DtoToDomainConverter
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import com.instaleap.dato.responses.genresMovies.GenresMoviesResponse
import org.koin.dsl.module

val dtoConverterModule = module {
    single<IDtoToDomainConverter> { DtoToDomainConverter() }
}