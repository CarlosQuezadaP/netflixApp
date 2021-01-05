package com.instaleap.usecases.repository

import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
    suspend fun getPopularTvs(page: Int): List<TVDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
}
