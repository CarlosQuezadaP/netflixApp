package com.instaleap.usecases.di

import com.instaleap.usecases.GetAllMoviesUseCase
import com.instaleap.usecases.IGetAllMoviesUseCase
import org.koin.dsl.module

val usescase_module = module {
    single<IGetAllMoviesUseCase> { GetAllMoviesUseCase(get()) }
}