package com.vmac.giphy.network.repository

import com.vmac.giphy.network.client.GiphyClient
import com.vmac.giphy.domain.GifRepository
import com.vmac.giphy.domain.model.TrendingGifs
import io.reactivex.Single
import javax.inject.Inject

class NetworkGifRepository @Inject constructor(
    private val client: GiphyClient,
    private val mapper: TrendingGifDtoMapper
) : GifRepository {

    override fun getTrendingGifs(
        offset: Int,
        limit: Int
    ): Single<TrendingGifs> {
        return client
            .getTrending(
                api_key = API_KEY,
                offset = offset,
                limit = limit
            )
            .map(mapper::map)
    }

    companion object {
        private const val API_KEY: String = "WGOCD0YLa9KGaotBWYfkoqu5qVCFYH3w"
    }
}