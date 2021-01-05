package com.instaleap.usecases.di

import com.instaleap.usecases.GetAllModelsSectionsUseCase
import com.instaleap.usecases.GetAllMoviesGenres
import com.instaleap.usecases.IGetAllModelsSections
import com.instaleap.usecases.IGetMoviesGenres
import org.koin.dsl.module

val usescase_module = module {
    single<IGetAllModelsSections> { GetAllModelsSectionsUseCase(get()) }
    single<IGetMoviesGenres> { GetAllMoviesGenres(get()) }
}
