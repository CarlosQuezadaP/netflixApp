package com.instaleap.dato.responses.discoverTv

import com.instaleap.dato.dto.SerieDto

data class DiscoverTvResponse(
    val page: Int,
    val results: List<SerieDto>,
    val total_pages: Int,
    val total_results: Int
)