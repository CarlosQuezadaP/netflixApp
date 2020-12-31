package com.instaleap.usecases.repository

import com.instaleap.domain.models.MovieItemDomain

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
}
