package com.instaleap.usecases

import com.instaleap.core.Resource
import com.instaleap.domain.models.*
import com.instaleap.usecases.repository.IMovieRepository


class GetPopularMoviesUseCase(private val iMovieRepository: IMovieRepository) :
    IGetPopularMoviesUseCase {

    override suspend fun invoke(page: Int): Resource<List<MovieItemDomain>> {
        return iMovieRepository.getPopularMovies(page)
    }

}

class GetPopularSeriesUseCase(private val iMovieRepository: IMovieRepository) :
    IGetPopularSeriesUseCase {

    override suspend fun invoke(page: Int): Resource<List<SerieDomain>> {
        return iMovieRepository.getPopularTvs(page)
    }
}


class GetAllMoviesGenresUseCase(private val iMovieRepository: IMovieRepository) :
    IGetAllMoviesGenresUseCase {

    override suspend fun invoke(): Resource<List<GenreItemDomain>> {
        return iMovieRepository.getGenresMovies()
    }
}

class GetMoviesByGenreUseCase(private val iMovieRepository: IMovieRepository) :
    IGetMoviesByGenreUseCase {
    override suspend fun invoke(page: Int, genreID: Int): Resource<List<MovieItemDomain>> {
        if (genreID != 0) {
            return iMovieRepository.getMoviesByGenre(page, genreID)
        }
        return iMovieRepository.getMoviesWithoutGenre(page)
    }
}

class GetSeriesByGenreUseCase(private val iMovieRepository: IMovieRepository) :
    IGetSeriesByGenreUseCase {
    override suspend fun invoke(page: Int, genreID: Int): Resource<List<SerieDomain>> {
        if (genreID != 0) {
            return iMovieRepository.getTvsByGenre(page, genreID)
        }
        return iMovieRepository.getTvsWithoutGenre(page)
    }
}

class GetMovieDetailUseCase(private val iMovieRepository: IMovieRepository) :
    IGetMovieDetailUseCase {
    override suspend fun invoke(movieId: Int): Resource<MovieDetailDomain> {
        return iMovieRepository.getDetailMovie(movieId)
    }
}

class GetSerieDetailUseCase(private val iMovieRepository: IMovieRepository) :
    IGetSerieDetailUseCase {
    override suspend fun invoke(movieId: Int): Resource<SerieDetailDomain> {
        return iMovieRepository.getDetailSerie(movieId)
    }
}

interface IGetPopularMoviesUseCase {
    suspend fun invoke(page: Int): Resource<List<MovieItemDomain>>
}

interface IGetPopularSeriesUseCase {
    suspend fun invoke(page: Int): Resource<List<SerieDomain>>
}

interface IGetAllMoviesGenresUseCase {
    suspend fun invoke(): Resource<List<GenreItemDomain>>
}

interface IGetMoviesByGenreUseCase {
    suspend fun invoke(page: Int, genreID: Int): Resource<List<MovieItemDomain>>
}

interface IGetSeriesByGenreUseCase {
    suspend fun invoke(page: Int, genreID: Int): Resource<List<SerieDomain>>
}

interface IGetMovieDetailUseCase {
    suspend fun invoke(movieId: Int): Resource<MovieDetailDomain>
}

interface IGetSerieDetailUseCase {
    suspend fun invoke(movieId: Int): Resource<SerieDetailDomain>
}