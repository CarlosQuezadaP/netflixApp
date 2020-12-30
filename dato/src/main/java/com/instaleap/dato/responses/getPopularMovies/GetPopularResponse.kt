package com.instaleap.dato.responses.getPopularMovies

import com.instaleap.dato.dto.MovieDto

data class GetPopularResponse(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)