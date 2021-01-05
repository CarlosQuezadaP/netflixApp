package com.instaleap.netflixapp.di

import com.instaleap.netflixapp.viewmodels.GenresMovieUseCaseViewModel
import com.instaleap.netflixapp.viewmodels.HomeUseCaseViewModel
import com.instaleap.netflixapp.viewmodels.MovieByGenreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel { HomeUseCaseViewModel(get()) }
    viewModel { GenresMovieUseCaseViewModel(get()) }
    viewModel { MovieByGenreViewModel(get()) }
}