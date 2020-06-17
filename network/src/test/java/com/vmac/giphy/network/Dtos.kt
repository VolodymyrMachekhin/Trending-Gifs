package com.vmac.giphy.network

import com.vmac.giphy.network.entity.GifDto
import com.vmac.giphy.network.entity.ImageDto
import com.vmac.giphy.network.entity.ImagesDto
import com.vmac.giphy.network.entity.PaginationDto
import com.vmac.giphy.network.entity.TrendingGifsDto
import com.vmac.giphy.network.entity.UserDto

val trendingGifsDto: TrendingGifsDto = TrendingGifsDto(
    data = listOf(
        GifDto(
            id = "URqAhy8IK1yltsFNjL",
            user = UserDto(
                avatarUrl = "https://media4.giphy.com/avatars/hannahbrown/5P9RMzfHbZcB.gif",
                userName = "hannahbrown"
            ),
            username = "hannahbrown",
            title = "The Bachelor Alabama Hannah GIF by Hannah Brown",
            images = ImagesDto(
                fixedWidthDownsampled = ImageDto(
                    height = 150,
                    width = 200,
                    url = "https://media3.giphy.com/media/URqAhy8IK1yltsFNjL/200w_d.gif?cid=0bdd689027788eddc964b925f8844d6f0d70435b7f4f64b8&rid=200w_d.gif"
                )
            )
        )
    ),
    pagination = PaginationDto(
        totalCount = 104354,
        offset = 0,
        count = 1
    )
)