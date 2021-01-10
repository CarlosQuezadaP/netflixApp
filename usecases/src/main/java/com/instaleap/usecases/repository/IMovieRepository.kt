package com.instaleap.usecases.repository

import com.instaleap.core.Resource
import com.instaleap.domain.models.*

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int): Resource<List<MovieItemDomain>>
    suspend fun getMoviesByGenre(page: Int, genreID: Int): Resource<List<MovieItemDomain>>
    suspend fun getMoviesWithoutGenre(page: Int): Resource<List<MovieItemDomain>>
    suspend fun getGenresMovies(): Resource<List<GenreItemDomain>>
    suspend fun getPopularTvs(page: Int): Resource<List<SerieDomain>>
    suspend fun getTvsByGenre(page: Int, genreID: Int): Resource<List<SerieDomain>>
    suspend fun getTvsWithoutGenre(page: Int): Resource<List<SerieDomain>>
    suspend fun getDetailMovie(idMovie: Int): Resource<MovieDetailDomain>
    suspend fun getDetailSerie(idSerie: Int): Resource<SerieDetailDomain>


}
