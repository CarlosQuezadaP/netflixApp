package com.instaleap.usecases

import com.instaleap.domain.CharacterModel
import com.instaleap.domain.SectionModel
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain
import com.instaleap.usecases.repository.IMovieRepository


class GetAllModelsSectionsUseCase(private val iMovieRepository: IMovieRepository) :
    IGetAllModelsSections {


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

class GetAllMoviesGenres(private val iMovieRepository: IMovieRepository) :
    IGetMoviesGenres {

    override suspend fun invoke(): List<GenreItemDomain> {
        return iMovieRepository.getGenresMovies()
    }
}

class GetMoviesByGenreUseCase(private val iMovieRepository: IMovieRepository) : IGetMoviesByGenre {
    override suspend fun invoke(page: Int, genreID: Int): List<MovieItemDomain> {
        if (genreID != 0) {
            return iMovieRepository.getMoviesByGenre(page, genreID)
        }
        return iMovieRepository.getMoviesWithoutGenre(page)
    }
}


interface IGetAllModelsSections {
    suspend fun invoke(page: Int): List<SectionModel>
}

interface IGetMoviesGenres {
    suspend fun invoke(): List<GenreItemDomain>
}

interface IGetMoviesByGenre {
    suspend fun invoke(page: Int, genreID: Int): List<MovieItemDomain>
}
