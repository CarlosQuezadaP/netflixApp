package com.instaleap.usecases

import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.usecases.repository.IMovieRepository

class GetAllMoviesUseCase(private val iMovieRepository: IMovieRepository) {
    operator suspend fun invoke(page: Int): List<MovieItemDomain> {
        return iMovieRepository.getPopularMovies(page)
    }
}