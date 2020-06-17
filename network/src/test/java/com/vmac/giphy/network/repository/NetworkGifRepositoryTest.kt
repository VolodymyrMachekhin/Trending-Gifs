package com.vmac.giphy.network.repository

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.vmac.giphy.network.client.GiphyClient
import com.vmac.giphy.network.trendingGifsDto
import io.reactivex.Single
import org.junit.Test
import java.util.Random

class NetworkGifRepositoryTest {

    @Test
    fun `when getTrendingGifs then calls client getTrending and maps result`() {
        val offset: Int = Random().nextInt()
        val limit: Int = Random().nextInt()

        val client: GiphyClient = mock {
            on {
                getTrending(
                    api_key = "WGOCD0YLa9KGaotBWYfkoqu5qVCFYH3w",
                    offset = offset,
                    limit = limit
                )
            } doReturn Single.just(trendingGifsDto)
        }

        val mapper: TrendingGifDtoMapper = mock {
            on { map(trendingGifsDto) } doReturn com.vmac.giphy.test.commons.trendingGifs
        }

        NetworkGifRepository(
            client = client,
            mapper = mapper
        )
            .getTrendingGifs(
                offset = offset,
                limit = limit
            )
            .test()
            .assertValue(com.vmac.giphy.test.commons.trendingGifs)
    }
}