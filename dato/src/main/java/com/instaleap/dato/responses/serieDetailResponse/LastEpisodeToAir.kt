package com.instaleap.dato.responses.serieDetailResponse

data class LastEpisodeToAir(
    val air_date: String,
    val episode_number: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val production_code: String,
    val season_number: Int,
    val still_path: Any,
    val vote_average: Float,
    val vote_count: Int
)