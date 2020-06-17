package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class GifDto(
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "user")
    val user: UserDto?,

    @field:Json(name = "username")
    val username: String,

    @field:Json(name = "images")
    val images: ImagesDto,

    @field:Json(name = "title")
    val title: String
)