package com.instaleap.dato.datasource

import com.instaleap.dato.domain.GenreItemDomain
import com.instaleap.dato.domain.MovieItemDomain
import com.instaleap.dato.domain.TVDomain

interface IMovieDataSource {
    suspend fun getPopularMovies(page:Int): List<MovieItemDomain>
    suspend fun getPopularTvs(page:Int): List<TVDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
    suspend fun getGenresTvs(): List<GenreItemDomain>
    suspend fun getDiscoverMovie(page:Int, idGenre:Int): List<MovieItemDomain>
    suspend fun getDiscoverTv(page:Int, idGenre:Int): List<TVDomain>
}