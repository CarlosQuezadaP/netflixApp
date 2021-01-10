package com.instaleap.dato.datasource

import com.instaleap.dato.IMovieApi
import com.instaleap.dato.anticorruption.IDtoToDomainConverter
import khalid.com.newssearcherv4.repositories.BaseRepository

class MovieDataSource2 constructor(
    private val iMovieApi: IMovieApi,
    private val converter: IDtoToDomainConverter
) : BaseRepository() {


    suspend fun getDiscoverMovie() = safeApiCall { iMovieApi.getMoviesListWitouthGenre_(1) }.map {
        it.results.map {
            converter.convertDtoToDomain(it)
        }
    }


}