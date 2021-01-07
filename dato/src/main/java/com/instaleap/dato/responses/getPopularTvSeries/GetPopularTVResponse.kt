package com.instaleap.dato.responses.getPopularTvSeries

import com.instaleap.dato.dto.SerieDto

data class GetPopularTVResponse(
    val page: Int,
    val results: List<SerieDto>,
    val total_pages: Int,
    val total_results: Int
)