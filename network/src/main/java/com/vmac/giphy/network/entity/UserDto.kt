package com.vmac.giphy.network.entity

import com.squareup.moshi.Json

data class UserDto(
    @field:Json(name = "avatar_url")
    val avatarUrl: String?,

    @field:Json(name = "username")
    val userName: String
)