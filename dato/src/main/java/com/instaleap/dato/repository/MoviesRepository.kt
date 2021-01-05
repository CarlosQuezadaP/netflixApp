package com.instaleap.dato.repository

import com.instaleap.dato.datasource.IMovieDataSource
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain
import com.instaleap.usecases.repository.IMovieRepository

class MoviesRepository(private val iMovieDataSource: IMovieDataSource) :
    IMovieRepository {

    override suspend fun getPopularMovies(page: Int): List<MovieItemDomain> =
        iMovieDataSource.getPopularMovies(page)

    override suspend fun getGenresMovies(): List<GenreItemDomain> {
        return iMovieDataSource.getGenresMovies()
    }

    override suspend fun getPopularTvs(page: Int): List<TVDomain> {
        return iMovieDataSource.getPopularTvs(page)
    }


}