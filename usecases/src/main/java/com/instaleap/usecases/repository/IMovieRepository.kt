package com.instaleap.usecases.repository

import com.instaleap.domain.models.*

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
    suspend fun getMoviesByGenre(page: Int, genreID: Int): List<MovieItemDomain>
    suspend fun getMoviesWithoutGenre(page: Int): List<MovieItemDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
    suspend fun getPopularTvs(page: Int): List<SerieDomain>
    suspend fun getTvsByGenre(page: Int, genreID: Int): List<SerieDomain>
    suspend fun getTvsWithoutGenre(page: Int): List<SerieDomain>
    suspend fun getDetailMovie(idMovie: Int): MovieDetailDomain
    suspend fun getDetailSerie(idSerie: Int): SerieDetailDomain
}
