package com.instaleap.dato.datasource

import com.instaleap.dato.IMovieApi
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import com.instaleap.dato.base.BaseRepository

class MovieDataSource constructor(
    private val iMovieApi: IMovieApi,
    private val converter: IDtoToDomainConverter,
) : BaseRepository(), IMovieDataSource {


    override suspend fun getPopularMovies(page: Int) = safeApiCall {
        iMovieApi.getPopularMovie(page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }


    override suspend fun getPopularTvs(page: Int) = safeApiCall {
        iMovieApi.getTVSeries(page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getGenresMovies() = safeApiCall {
        iMovieApi.getGenresMovieList()
    }.map {
        it.genres.map {
            converter.convertDtoToDomain(it)
        }
    }


    override suspend fun getGenresTvs() = safeApiCall {
        iMovieApi.getGenresTvList()
    }.map {
        it.genres.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getDiscoverMovie(page: Int, idGenre: Int) = safeApiCall {
        iMovieApi.getMoviesListByGenre(idGenre, page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getDiscoverMovieWithoutGenre(page: Int) = safeApiCall {
        iMovieApi.getMoviesListWitouthGenre(page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getDiscoverTv(page: Int, idGenre: Int) = safeApiCall {
        iMovieApi.getTvListByGenre(idGenre, page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getDiscoverWithoutGenreTv(page: Int) = safeApiCall {
        iMovieApi.getTvListWithoutGenre(page)
    }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }

    override suspend fun getMovieDetail(movieId: Int) = safeApiCall {
        iMovieApi.getMovieDetail(movieId)
    }.map {
        converter.convertDtoToDomain(it)
    }

    override suspend fun getSerieDetail(serieID: Int) = safeApiCall {
        iMovieApi.getSerieDetail(serieID)
    }.map {
        converter.convertDtoToDomain(it)
    }
}