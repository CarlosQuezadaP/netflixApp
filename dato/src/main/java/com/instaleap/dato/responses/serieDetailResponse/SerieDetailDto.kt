package com.instaleap.dato.responses.serieDetailResponse

import com.instaleap.domain.models.GenreItemDomain

data class SerieDetailDto(
    val backdrop_path: String?,
    val poster_path: String?,
    val created_by: List<Any>,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<GenreItemDomain>,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val last_episode_to_air: LastEpisodeToAir,
    val name: String,
    val networks: List<Network>,
    val next_episode_to_air: Any,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val seasons: List<Season>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Float,
    val vote_count: Int
)