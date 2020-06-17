package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class ImagesDto(
    @field:Json(name = "fixed_width_downsampled")
    val fixedWidthDownsampled: ImageDto
)