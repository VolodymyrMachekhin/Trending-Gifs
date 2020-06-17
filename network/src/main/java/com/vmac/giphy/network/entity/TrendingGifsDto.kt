package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class TrendingGifsDto(

    @field:Json(name = "data")
    val data: List<GifDto>,

    @field:Json(name = "pagination")
    val pagination: PaginationDto
)