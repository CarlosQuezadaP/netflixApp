package com.instaleap.domain.serie

data class SeasonVO(
    val air_date: String,
    val episode_count: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: Any,
    val season_number: Int
)