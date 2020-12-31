package com.instaleap.dato.anticorruption

import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain
import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto

interface IDtoToDomainConverter {
    fun convertDtoToDomain(movieDto: MovieDto): MovieItemDomain
    fun convertDtoToDomain(genreDto: GenreDto): GenreItemDomain
    fun convertDtoToDomain(tVDto: TVDto): TVDomain
}