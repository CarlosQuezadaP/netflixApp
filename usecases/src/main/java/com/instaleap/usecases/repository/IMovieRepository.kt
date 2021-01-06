package com.instaleap.usecases.repository

import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
    suspend fun getMoviesByGenre(page: Int, genreID: Int): List<MovieItemDomain>
    suspend fun getMoviesWithoutGenre(page: Int): List<MovieItemDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
    suspend fun getPopularTvs(page: Int): List<TVDomain>
    suspend fun getTvsByGenre(page: Int, genreID: Int): List<TVDomain>
    suspend fun getTvsWithoutGenre(page: Int): List<TVDomain>
    suspend fun getDetailMovie(idMovie: Int): MovieDetailDomain
}
