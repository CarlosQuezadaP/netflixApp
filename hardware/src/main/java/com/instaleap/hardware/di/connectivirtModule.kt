package com.instaleap.hardware.di

import com.instaleap.domain.IConnectivity
import com.instaleap.hardware.red.ConnectivityImp
import org.koin.dsl.module

val connectivityModule = module {
    single<IConnectivity> { ConnectivityImp(get()) }
}