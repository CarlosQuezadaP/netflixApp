package com.instaleap.dato.datasource

import com.instaleap.dato.IMovieApi
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain
import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto
import java.lang.Exception

class MovieDataSource constructor(
    private val iMovieApi: IMovieApi,
    private val converter: IDtoToDomainConverter,
) : IMovieDataSource {


    override suspend fun getPopularMovies(page: Int): List<MovieItemDomain> {
        val moviesResponse = iMovieApi.getPopularMovie(page)
        val movies: List<MovieDto>?
        var moviesDomain: List<MovieItemDomain>? = null
        if (moviesResponse.isSuccessful) {
            movies = moviesResponse.body()?.results
            moviesDomain = movies?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return moviesDomain ?: throw Exception("No hay peliculas")
    }

    override suspend fun getPopularTvs(page: Int): List<TVDomain> {
        val tvsResponse = iMovieApi.getTVSeries(page)
        val tvs: List<TVDto>?
        var tvsDomain: List<TVDomain>? = null
        if (tvsResponse.isSuccessful) {
            tvs = tvsResponse.body()?.results
            tvsDomain = tvs?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return tvsDomain ?: throw Exception("No hay series")
    }

    override suspend fun getGenresMovies(): List<GenreItemDomain> {
        val genresMovieResponse = iMovieApi.getGenresMovieList()
        val genres: List<GenreDto>?
        var genresDomain: List<GenreItemDomain>? = null
        if (genresMovieResponse.isSuccessful) {
            genres = genresMovieResponse.body()?.genres
            genresDomain = genres?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return genresDomain ?: throw Exception("No hay generos de peliculas")
    }

    override suspend fun getGenresTvs(): List<GenreItemDomain> {
        val genresTvResponse = iMovieApi.getGenresTvList()
        val genres: List<GenreDto>?
        var genresDomain: List<GenreItemDomain>? = null
        if (genresTvResponse.isSuccessful) {
            genres = genresTvResponse.body()?.genres
            genresDomain = genres?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return genresDomain ?: throw Exception("No hay generos de series")
    }

    override suspend fun getDiscoverMovie(page: Int, idGenre: Int): List<MovieItemDomain> {
        val moviesResponse = iMovieApi.getMoviesListByGenre(idGenre, page)
        val movies: List<MovieDto>?
        var moviesDomain: List<MovieItemDomain>? = null
        if (moviesResponse.isSuccessful) {
            movies = moviesResponse.body()?.results
            moviesDomain = movies?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return moviesDomain ?: throw Exception("No hay peliculas")
    }

    override suspend fun getDiscoverTv(page: Int, idGenre: Int): List<TVDomain> {
        val tvsResponse = iMovieApi.getTvListByGenre(idGenre, page)
        val tvs: List<TVDto>?
        var tvsDomain: List<TVDomain>? = null
        if (tvsResponse.isSuccessful) {
            tvs = tvsResponse.body()?.results
            tvsDomain = tvs?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return tvsDomain ?: throw Exception("No hay series")
    }


}