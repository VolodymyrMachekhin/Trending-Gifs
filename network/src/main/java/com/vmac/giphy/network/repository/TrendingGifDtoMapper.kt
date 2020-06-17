package com.vmac.giphy.network.repository

import com.vmac.giphy.domain.Mapper
import com.vmac.giphy.domain.model.TrendingGifs
import com.vmac.giphy.network.entity.TrendingGifsDto
import javax.inject.Inject

class TrendingGifDtoMapper @Inject constructor(
    private val gifDtoMapper: GifDtoMapper
): Mapper<TrendingGifsDto, TrendingGifs> {

    override fun map(from: TrendingGifsDto): TrendingGifs {
        return TrendingGifs(
            items = from.data.map(gifDtoMapper::map),
            totalTrendingCount = from.pagination.totalCount
        )
    }
}