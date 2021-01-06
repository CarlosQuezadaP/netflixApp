package com.instaleap.dato.anticorruption

import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.TVDto
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import com.instaleap.domain.models.GenreItemDomain
import com.instaleap.domain.models.MovieDetailDomain
import com.instaleap.domain.models.MovieItemDomain
import com.instaleap.domain.models.TVDomain

class DtoToDomainConverter : IDtoToDomainConverter {

    override fun convertDtoToDomain(movieDto: MovieDto) =
        MovieItemDomain(
            id = movieDto.id,
            voteCount = movieDto.vote_count,
            voteAverage = movieDto.vote_average,
            isVideo = movieDto.video,
            title = movieDto.title,
            popularity = movieDto.popularity,
            posterPath = movieDto.poster_path.orEmpty(),
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
            backdrop_path = tVDto.backdrop_path.orEmpty(),
            first_air_date = tVDto.first_air_date,
            genre_ids = tVDto.genre_ids,
            id = tVDto.id,
            name = tVDto.name,
            origin_country = tVDto.origin_country,
            original_language = tVDto.original_language,
            original_name = tVDto.original_name,
            overview = tVDto.overview,
            popularity = tVDto.popularity,
            poster_path = tVDto.poster_path.orEmpty(),
            vote_average = tVDto.vote_average,
            vote_count = tVDto.vote_count
        )

    override fun convertDtoToDomain(detailDto: MovieDetailDto): MovieDetailDomain {
        val genres = detailDto.genres.map {
            convertDtoToDomain(it)
        }

        return MovieDetailDomain(
            adult = detailDto.adult,
            backdrop_path = detailDto.backdrop_path,
            budget = detailDto.budget,
            genres = genres,
            homepage = detailDto.homepage,
            id = detailDto.id,
            imdb_id = detailDto.imdb_id,
            original_language = detailDto.original_language,
            original_title = detailDto.original_title,
            overview = detailDto.overview,
            popularity = detailDto.popularity,
            poster_path = detailDto.poster_path,
            release_date = detailDto.release_date,
            revenue = detailDto.revenue,
            runtime = detailDto.runtime,
            status = detailDto.status,
            tagline = detailDto.tagline,
            title = detailDto.title,
            video = detailDto.video,
            vote_average = detailDto.vote_average,
            vote_count = detailDto.vote_count
        )
    }


}