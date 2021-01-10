package com.instaleap.dato.repository

import com.instaleap.core.Resource
import com.instaleap.dato.datasource.IMovieDataSource
import com.instaleap.domain.models.*
import com.instaleap.usecases.repository.IMovieRepository

class MoviesRepository(private val iMovieDataSource: IMovieDataSource) :
    IMovieRepository {

    override suspend fun getPopularMovies(page: Int): Resource<List<MovieItemDomain>> =
        iMovieDataSource.getPopularMovies(page)

    override suspend fun getMoviesByGenre(page: Int, genreID: Int): Resource<List<MovieItemDomain>> {
        return iMovieDataSource.getDiscoverMovie(page, genreID)
    }

    override suspend fun getMoviesWithoutGenre(page: Int): Resource<List<MovieItemDomain>> {
        return iMovieDataSource.getDiscoverMovieWithoutGenre(page)
    }

    override suspend fun getTvsWithoutGenre(page: Int): Resource<List<SerieDomain>> {
        return iMovieDataSource.getDiscoverWithoutGenreTv(page)
    }

    override suspend fun getDetailMovie(idMovie: Int): Resource<MovieDetailDomain> {
        return iMovieDataSource.getMovieDetail(idMovie)
    }

    override suspend fun getDetailSerie(idSerie: Int): Resource<SerieDetailDomain> {
        return iMovieDataSource.getSerieDetail(idSerie)
    }

    override suspend fun getPopularTvs(page: Int): Resource<List<SerieDomain>> {
        return iMovieDataSource.getPopularTvs(page)
    }

    override suspend fun getTvsByGenre(page: Int, genreID: Int): Resource<List<SerieDomain>> {
        return iMovieDataSource.getDiscoverTv(page, genreID)
    }


    override suspend fun getGenresMovies(): Resource<List<GenreItemDomain>> {
        return iMovieDataSource.getGenresMovies()
    }


}