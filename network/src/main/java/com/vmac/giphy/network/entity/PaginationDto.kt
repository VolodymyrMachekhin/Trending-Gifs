package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class PaginationDto(
    @field:Json(name = "total_count")
    val totalCount: Int,

    @field:Json(name = "offset")
    val offset: Int,

    @field:Json(name = "count")
    val count: Int
)