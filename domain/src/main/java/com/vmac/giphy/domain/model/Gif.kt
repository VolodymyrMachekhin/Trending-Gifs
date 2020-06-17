package com.vmac.giphy.domain.model

data class Gif(
    val id: GifId,
    val author: User,
    val thumbnailUrl: String,
    val imageSize: ImageSize,
    val title: String
)

inline class GifId(val value: String)