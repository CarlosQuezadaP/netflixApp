package com.instaleap.dato.datasource

import com.instaleap.domain.models.*

interface IMovieDataSource {
    suspend fun getPopularMovies(page: Int): List<MovieItemDomain>
    suspend fun getPopularTvs(page: Int): List<SerieDomain>
    suspend fun getGenresMovies(): List<GenreItemDomain>
    suspend fun getGenresTvs(): List<GenreItemDomain>
    suspend fun getDiscoverMovie(page: Int, idGenre: Int): List<MovieItemDomain>
    suspend fun getDiscoverMovieWithoutGenre(page: Int): List<MovieItemDomain>
    suspend fun getDiscoverTv(page: Int, idGenre: Int): List<SerieDomain>
    suspend fun getDiscoverWithoutGenreTv(page: Int): List<SerieDomain>
    suspend fun getMovieDetail(movieId: Int): MovieDetailDomain
    suspend fun getSerieDetail(serieID: Int): SerieDetailDomain
}