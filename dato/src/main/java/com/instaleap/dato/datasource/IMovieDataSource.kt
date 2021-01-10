package com.instaleap.dato.datasource

import com.instaleap.core.Resource
import com.instaleap.domain.models.*

interface IMovieDataSource {
    suspend fun getPopularMovies(page: Int): Resource<List<MovieItemDomain>>
    suspend fun getPopularTvs(page: Int): Resource<List<SerieDomain>>
    suspend fun getGenresMovies(): Resource<List<GenreItemDomain>>
    suspend fun getGenresTvs(): Resource<List<GenreItemDomain>>
    suspend fun getDiscoverMovie(page: Int, idGenre: Int): Resource<List<MovieItemDomain>>
    suspend fun getDiscoverMovieWithoutGenre(page: Int): Resource<List<MovieItemDomain>>
    suspend fun getDiscoverTv(page: Int, idGenre: Int): Resource<List<SerieDomain>>
    suspend fun getDiscoverWithoutGenreTv(page: Int): Resource<List<SerieDomain>>
    suspend fun getMovieDetail(movieId: Int): Resource<MovieDetailDomain>
    suspend fun getSerieDetail(serieID: Int): Resource<SerieDetailDomain>


}