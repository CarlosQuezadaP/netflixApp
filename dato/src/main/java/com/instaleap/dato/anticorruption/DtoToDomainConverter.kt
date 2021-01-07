package com.instaleap.dato.anticorruption

import com.instaleap.dato.dto.GenreDto
import com.instaleap.dato.dto.MovieDto
import com.instaleap.dato.dto.SerieDto
import com.instaleap.dato.responses.movieDatailResponse.MovieDetailDto
import com.instaleap.dato.responses.serieDetailResponse.SerieDetailDto
import com.instaleap.domain.models.*

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

    override fun convertDtoToDomain(tVDto: SerieDto) =
        SerieDomain(
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

    override fun convertDtoToDomain(serieDetailDto: SerieDetailDto): SerieDetailDomain {
        val serieDetailDomain = SerieDetailDomain(
            backdrop_path = serieDetailDto.backdrop_path,
            first_air_date = serieDetailDto.first_air_date,
            genres = serieDetailDto.genres,
            homepage = serieDetailDto.homepage,
            id = serieDetailDto.id,
            in_production = serieDetailDto.in_production,
            languages = serieDetailDto.languages,
            last_air_date = serieDetailDto.last_air_date,
            name = serieDetailDto.name,
            number_of_episodes = serieDetailDto.number_of_episodes,
            number_of_seasons = serieDetailDto.number_of_seasons,
            origin_country = serieDetailDto.origin_country,
            original_language = serieDetailDto.original_language,
            original_name = serieDetailDto.original_name,
            overview = serieDetailDto.overview,
            popularity = serieDetailDto.popularity,
            poster_path = serieDetailDto.poster_path,
            status = serieDetailDto.status,
            tagline = serieDetailDto.tagline,
            type = serieDetailDto.type,
            vote_average = serieDetailDto.vote_average,
            vote_count = serieDetailDto.vote_count,
            episode_run_time = serieDetailDto.episode_run_time
        )
        return serieDetailDomain
    }


}