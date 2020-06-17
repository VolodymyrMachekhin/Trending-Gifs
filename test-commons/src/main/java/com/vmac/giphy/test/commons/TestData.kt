package com.vmac.giphy.test.commons

import com.vmac.giphy.domain.logging.Logger
import com.vmac.giphy.domain.model.Gif
import com.vmac.giphy.domain.model.GifId
import com.vmac.giphy.domain.model.ImageSize
import com.vmac.giphy.domain.model.TrendingGifs
import com.vmac.giphy.domain.model.User

val trendingGifs = TrendingGifs(
    items = listOf(
        Gif(
            id = GifId("URqAhy8IK1yltsFNjL"),
            author = User(
                avatarUrl = "https://media4.giphy.com/avatars/hannahbrown/5P9RMzfHbZcB.gif",
                name = "hannahbrown"
            ),
            title = "The Bachelor Alabama Hannah GIF by Hannah Brown",
            thumbnailUrl = "https://media3.giphy.com/media/URqAhy8IK1yltsFNjL/200w_d.gif?cid=0bdd689027788eddc964b925f8844d6f0d70435b7f4f64b8&rid=200w_d.gif",
            imageSize = ImageSize(
                height = 150,
                width = 200
            )
        )
    ),
    totalTrendingCount = 104354
)

val testLogger = object : Logger {
    override fun e(throwable: Throwable?, message: String) {
    }

    override fun d(throwable: Throwable?, message: String) {
    }
}