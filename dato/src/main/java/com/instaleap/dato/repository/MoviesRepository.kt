package com.instaleap.dato.repository

import com.instaleap.dato.datasource.MovieDataSource
import com.instaleap.domain.models.MovieItemDomain

class MoviesRepository(private val movieDataSource: MovieDataSource) :
    com.instaleap.usecases.repository.IMovieRepository {

    override suspend fun getPopularMovies(page: Int): List<MovieItemDomain> =
        movieDataSource.getPopularMovies(page)


}