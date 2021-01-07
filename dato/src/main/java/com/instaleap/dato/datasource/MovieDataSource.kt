package com.instaleap.dato.datasource

import com.instaleap.dato.IMovieApi
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.SerieDto
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import com.instaleap.dato.responses.serieDetailResponse.SerieDetailDto
import com.instaleap.domain.models.*

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

    override suspend fun getPopularTvs(page: Int): List<SerieDomain> {
        val tvsResponse = iMovieApi.getTVSeries(page)
        val series: List<SerieDto>?
        var tvsDomain: List<SerieDomain>? = null
        if (tvsResponse.isSuccessful) {
            series = tvsResponse.body()?.results
            tvsDomain = series?.map {
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

    override suspend fun getDiscoverMovieWithoutGenre(page: Int): List<MovieItemDomain> {
        val moviesResponse = iMovieApi.getMoviesListWitouthGenre(page)
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

    override suspend fun getDiscoverTv(page: Int, idGenre: Int): List<SerieDomain> {
        val tvsResponse = iMovieApi.getTvListByGenre(idGenre, page)
        val series: List<SerieDto>?
        var tvsDomain: List<SerieDomain>? = null
        if (tvsResponse.isSuccessful) {
            series = tvsResponse.body()?.results
            tvsDomain = series?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return tvsDomain ?: throw Exception("No hay series")
    }

    override suspend fun getDiscoverWithoutGenreTv(page: Int): List<SerieDomain> {
        val tvsResponse = iMovieApi.getTvListWithoutGenre(page)
        val series: List<SerieDto>?
        var tvsDomain: List<SerieDomain>? = null
        if (tvsResponse.isSuccessful) {
            series = tvsResponse.body()?.results
            tvsDomain = series?.map {
                converter.convertDtoToDomain(it)
            }
        }
        return tvsDomain ?: throw Exception("No hay series")
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetailDomain {
        val movieDetailResponse = iMovieApi.getMovieDetail(movieId)
        val movieDetailDto: MovieDetailDto?
        var movieDetailDomain: MovieDetailDomain? = null
        if (movieDetailResponse.isSuccessful) {
            movieDetailDto = movieDetailResponse.body()
            movieDetailDomain = converter.convertDtoToDomain(movieDetailDto!!)
        }
        return movieDetailDomain ?: throw Exception("No hay detalle para esta pelicula")
    }

    override suspend fun getSerieDetail(serieID: Int): SerieDetailDomain {
        val serieDetailResponse = iMovieApi.getSerieDetail(serieID)
        val serieDetailDto: SerieDetailDto?
        var serieDetailDomain: SerieDetailDomain? = null
        if (serieDetailResponse.isSuccessful) {
            serieDetailDto = serieDetailResponse.body()
            serieDetailDomain = converter.convertDtoToDomain(serieDetailDto!!)
        }
        return serieDetailDomain ?: throw Exception("No hay detalle para esta serie")
    }


}