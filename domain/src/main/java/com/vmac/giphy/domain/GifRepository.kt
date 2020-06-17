package com.vmac.giphy.domain

import com.vmac.giphy.domain.model.TrendingGifs
import io.reactivex.Single

interface GifRepository {

    fun getTrendingGifs(
        offset: Int = 0,
        limit: Int = DEFAULT_LIMIT
    ): Single<TrendingGifs>

    companion object {
        private const val DEFAULT_LIMIT: Int = 25
    }
}