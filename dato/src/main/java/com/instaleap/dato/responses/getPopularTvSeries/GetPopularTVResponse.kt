package com.instaleap.dato.responses.getPopularTvSeries

import com.instaleap.dato.dto.TVDto

data class GetPopularTVResponse(
    val page: Int,
    val results: List<TVDto>,
    val total_pages: Int,
    val total_results: Int
)