package com.instaleap.dato.anticorruption

import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import com.instaleap.dato.responses.serieDetailResponse.SerieDetailDto
import com.instaleap.domain.models.*

interface IDtoToDomainConverter {
    fun convertDtoToDomain(movieDto: MovieDto): MovieItemDomain
    fun convertDtoToDomain(genreDto: GenreDto): GenreItemDomain
    fun convertDtoToDomain(tVDto: TVDto): TVDomain
    fun convertDtoToDomain(detailDto: MovieDetailDto): MovieDetailDomain
    fun convertDtoToDomain(serieDetailDto: SerieDetailDto): SerieDetailDomain
}