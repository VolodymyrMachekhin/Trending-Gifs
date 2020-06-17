package com.vmac.giphy.network.repository

import com.vmac.giphy.domain.Mapper
import com.vmac.giphy.domain.model.Gif
import com.vmac.giphy.domain.model.GifId
import com.vmac.giphy.domain.model.ImageSize
import com.vmac.giphy.domain.model.User
import com.vmac.giphy.network.entity.GifDto
import com.vmac.giphy.network.entity.ImageDto
import javax.inject.Inject

class GifDtoMapper @Inject constructor(): Mapper<GifDto, Gif>{

    override fun map(from: GifDto): Gif {
        return Gif(
            id = GifId(from.id),
            imageSize = from.images.fixedWidthDownsampled.getImageSize(),
            thumbnailUrl = from.images.fixedWidthDownsampled.url,
            author = from.getAuthor(),
            title = from.title
        )
    }

    private fun ImageDto.getImageSize(): ImageSize {
        return ImageSize(
            width = width,
            height = height
        )
    }

    private fun GifDto.getAuthor(): User {
        return User(
            avatarUrl = user?.avatarUrl,
            name = user?.userName ?: username
        )
    }
}