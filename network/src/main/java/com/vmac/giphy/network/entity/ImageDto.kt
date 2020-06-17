package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class ImageDto(
    @field:Json(name = "url")
    val url: String,

    @field:Json(name = "width")
    val width: Int,

    @field:Json(name = "height")
    val height: Int
)