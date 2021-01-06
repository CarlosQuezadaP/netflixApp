package com.instaleap.dato.repository

import com.instaleap.dato.datasource.IMovieDataSource
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain
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

    override suspend fun getTvsWithoutGenre(page: Int): List<TVDomain> {
        return iMovieDataSource.getDiscoverWithoutGenreTv(page)
    }

    override suspend fun getDetailMovie(idMovie: Int): MovieDetailDomain {
        return iMovieDataSource.getMovieDetail(idMovie)
    }

    override suspend fun getPopularTvs(page: Int): List<TVDomain> {
        return iMovieDataSource.getPopularTvs(page)
    }

    override suspend fun getTvsByGenre(page: Int, genreID: Int): List<TVDomain> {
        return iMovieDataSource.getDiscoverTv(page, genreID)
    }


    override suspend fun getGenresMovies(): List<GenreItemDomain> {
        return iMovieDataSource.getGenresMovies()
    }


}