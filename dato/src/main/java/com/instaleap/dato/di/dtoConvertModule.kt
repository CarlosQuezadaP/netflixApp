package com.instaleap.dato.di

import com.instaleap.dato.anticorruption.DtoToDomainConverter
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import org.koin.dsl.module

val dtoConverterModule = module {
    single<IDtoToDomainConverter> { DtoToDomainConverter() }
}