package com.vmac.giphy.network.repository

import com.vmac.giphy.network.trendingGifsDto
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TrendingGifDtoMapperTest {

    @Test
    fun `test mapping TrendingGifsDto to domain TrendingGifs`() {
        val result = TrendingGifDtoMapper(
            GifDtoMapper()
        ).map(trendingGifsDto)
        assertEquals(com.vmac.giphy.test.commons.trendingGifs, result)
    }
}