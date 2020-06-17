package com.vmac.giphy.domain.model

data class TrendingGifs(
    val items: List<Gif>,
    val totalTrendingCount: Int
)