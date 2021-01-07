package com.instaleap.dato.repository

import com.instaleap.dato.datasource.IMovieDataSource
import com.instaleap.domain.models.*
import com.instaleap.usecases.repository.IMovieRepository

class MoviesRepository(private val iMovieDataSource: IMovieDataSource) :
    IMovieRepository {

    override suspend fun getPopularMovies(page: Int): List<MovieItemDomain> =
        iMovieDataSource.getPopularMovies(page)

    override suspend fun getMoviesByGenre(page: Int, genreID: Int): List<MovieItemDomain> {
        return iMovieDataSource.getDiscoverMovie(page, genreID)
    }

    override suspend fun getMoviesWithoutGenre(page: Int): List<MovieItemDomain> {
        return iMovieDataSource.getDiscoverMovieWithoutGenre(page)
    }

    override suspend fun getTvsWithoutGenre(page: Int): List<SerieDomain> {
        return iMovieDataSource.getDiscoverWithoutGenreTv(page)
    }

    override suspend fun getDetailMovie(idMovie: Int): MovieDetailDomain {
        return iMovieDataSource.getMovieDetail(idMovie)
    }

    override suspend fun getDetailSerie(idSerie: Int): SerieDetailDomain {
        return iMovieDataSource.getSerieDetail(idSerie)
    }

    override suspend fun getPopularTvs(page: Int): List<SerieDomain> {
        return iMovieDataSource.getPopularTvs(page)
    }

    override suspend fun getTvsByGenre(page: Int, genreID: Int): List<SerieDomain> {
        return iMovieDataSource.getDiscoverTv(page, genreID)
    }


    override suspend fun getGenresMovies(): List<GenreItemDomain> {
        return iMovieDataSource.getGenresMovies()
    }


}