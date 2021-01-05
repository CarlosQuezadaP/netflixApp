package com.instaleap.dato.datasource

import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain

interface IMovieDataSource {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
    suspend fun getPopularTvs(page: Int): List<TVDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
    suspend fun getGenresTvs(): List<GenreItemDomain>
    suspend fun getDiscoverMovie(page: Int, idGenre: Int): List<MovieItemDomain>
    suspend fun getDiscoverTv(page: Int, idGenre: Int): List<TVDomain>
}