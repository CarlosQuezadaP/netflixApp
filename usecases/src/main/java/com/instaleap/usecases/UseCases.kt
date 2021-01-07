package com.instaleap.usecases

import com.instaleap.domain.CharacterModel
import com.instaleap.domain.SectionModel
import com.instaleap.domain.models.*
import com.instaleap.usecases.repository.IMovieRepository


class GetAllModelsSectionsUseCase(private val iMovieRepository: IMovieRepository) :
    IGetAllModelsSectionsUseCase {


    override suspend fun invoke(page: Int): List<SectionModel> {
        val sectionMovie =
            generateMovieSection(getAllMovies(page))
        val sectionSerie = generateSerieSection(getAllSeries(page))
        return listOf(sectionMovie, sectionSerie)
    }

    private suspend fun getAllMovies(page: Int): List<MovieItemDomain> {
        return iMovieRepository.getPopularMovies(page)
    }

    private suspend fun getAllSeries(page: Int): List<TVDomain> {
        return iMovieRepository.getPopularTvs(page)
    }

    private fun generateMovieSection(
        movies: List<MovieItemDomain>,
    ): SectionModel {
        val moviesModels = movies

        val list = moviesModels.map {
            CharacterModel(it.posterPath, "Movie", it.id)
        }

        return SectionModel("Popular Movies", list)
    }

    private fun generateSerieSection(
        series: List<TVDomain>,
    ): SectionModel {
        val moviesModels = series

        val list = moviesModels.map {
            CharacterModel(it.poster_path, "Serie", it.id)
        }
        return SectionModel("Popular Series", list)
    }
}

class GetAllMoviesGenresUseCase(private val iMovieRepository: IMovieRepository) :
    IGetAllMoviesGenresUseCase {

    override suspend fun invoke(): List<GenreItemDomain> {
        return iMovieRepository.getGenresMovies()
    }
}

class GetMoviesByGenreUseCase(private val iMovieRepository: IMovieRepository) :
    IGetMoviesByGenreUseCase {
    override suspend fun invoke(page: Int, genreID: Int): List<MovieItemDomain> {
        if (genreID != 0) {
            return iMovieRepository.getMoviesByGenre(page, genreID)
        }
        return iMovieRepository.getMoviesWithoutGenre(page)
    }
}

class GetSeriesByGenreUseCase(private val iMovieRepository: IMovieRepository) :
    IGetSeriesByGenreUseCase {
    override suspend fun invoke(page: Int, genreID: Int): List<TVDomain> {
        if (genreID != 0) {
            return iMovieRepository.getTvsByGenre(page, genreID)
        }
        return iMovieRepository.getTvsWithoutGenre(page)
    }
}

class GetMovieDetailUseCase(private val iMovieRepository: IMovieRepository) :
    IGetMovieDetailUseCase {
    override suspend fun invoke(movieId: Int): MovieDetailDomain {
        return iMovieRepository.getDetailMovie(movieId)
    }
}

class GetSerieDetailUseCase(private val iMovieRepository: IMovieRepository) :
    IGetSerieDetailUseCase {
    override suspend fun invoke(movieId: Int): SerieDetailDomain {
        return iMovieRepository.getDetailSerie(movieId)
    }
}


interface IGetAllModelsSectionsUseCase {
    suspend fun invoke(page: Int): List<SectionModel>
}

interface IGetAllMoviesGenresUseCase {
    suspend fun invoke(): List<GenreItemDomain>
}

interface IGetMoviesByGenreUseCase {
    suspend fun invoke(page: Int, genreID: Int): List<MovieItemDomain>
}

interface IGetSeriesByGenreUseCase {
    suspend fun invoke(page: Int, genreID: Int): List<TVDomain>
}

interface IGetMovieDetailUseCase {
    suspend fun invoke(movieId: Int): MovieDetailDomain
}

interface IGetSerieDetailUseCase {
    suspend fun invoke(movieId: Int): SerieDetailDomain
}