package com.instaleap.dato.responses.discoverMovie

import com.instaleap.dato.dto.MovieDto

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)