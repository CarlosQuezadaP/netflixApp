package com.instaleap.dato.responses.discoverTv

import com.instaleap.dato.dto.TVDto

data class DiscoverTvResponse(
    val page: Int,
    val results: List<TVDto>,
    val total_pages: Int,
    val total_results: Int
)