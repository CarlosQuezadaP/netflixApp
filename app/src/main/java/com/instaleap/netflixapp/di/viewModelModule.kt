package com.instaleap.netflixapp.di

import com.instaleap.netflixapp.viewmodels.UseCasesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UseCasesViewModel(get()) }
}