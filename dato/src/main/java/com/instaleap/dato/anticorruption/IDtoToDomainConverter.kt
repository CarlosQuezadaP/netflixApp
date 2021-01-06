package com.instaleap.dato.anticorruption

import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain

interface IDtoToDomainConverter {
    fun convertDtoToDomain(movieDto: MovieDto): MovieItemDomain
    fun convertDtoToDomain(genreDto: GenreDto): GenreItemDomain
    fun convertDtoToDomain(tVDto: TVDto): TVDomain
    fun convertDtoToDomain(detailDto: MovieDetailDto): MovieDetailDomain
}