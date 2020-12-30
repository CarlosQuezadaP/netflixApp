package com.instaleap.dato.anticorruption

import com.instaleap.dato.domain.GenreItemDomain
import com.instaleap.dato.domain.MovieItemDomain
import com.instaleap.dato.domain.TVDomain
import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto

class DtoToDomainConverter() : IDtoToDomainConverter {

    override fun convertDtoToDomain(movieDto: MovieDto) =
        MovieItemDomain(
            id = movieDto.id,
            voteCount = movieDto.vote_count,
            voteAverage = movieDto.vote_average,
            isVideo = movieDto.video,
            title = movieDto.title,
            popularity = movieDto.popularity,
            posterPath = movieDto.poster_path,
            originalLanguage = movieDto.original_language,
            originalTitle = movieDto.original_title.orEmpty(),
            genreIds = movieDto.genre_ids,
            backdropPath = movieDto.backdrop_path.orEmpty(),
            releaseDate = movieDto.release_date,
            adult = movieDto.adult,
            overview = movieDto.overview.orEmpty()
        )

    override fun convertDtoToDomain(genreDto: GenreDto) =
        GenreItemDomain(genreDto.id, genreDto.name)

    override fun convertDtoToDomain(tVDto: TVDto) =
        TVDomain(
            backdrop_path = tVDto.backdrop_path,
            first_air_date = tVDto.first_air_date,
            genre_ids = tVDto.genre_ids,
            id = tVDto.id,
            name = tVDto.name,
            origin_country = tVDto.origin_country,
            original_language = tVDto.original_language,
            original_name = tVDto.original_name,
            overview = tVDto.overview,
            popularity = tVDto.popularity,
            poster_path = tVDto.poster_path,
            vote_average = tVDto.vote_average,
            vote_count = tVDto.vote_count
        )

}