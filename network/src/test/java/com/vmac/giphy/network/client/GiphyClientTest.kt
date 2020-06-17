package com.vmac.giphy.network.client

import com.vmac.giphy.test.commons.trendingGifsDto
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class GiphyClientTest {
    private val server: MockWebServer = MockWebServer()
    private lateinit var client: GiphyClient

    @Before
    fun setUp() {
        server.start()
        client = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(GiphyClient::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun `test deserialization of getTrending response`() {
        server.enqueue(MockResponse().setBody(getStringFromJson("trending_giphies.json")))
        client.getTrending(api_key = "", offset = 0, limit = 0)
            .test()
            .assertComplete()
            .assertValue(com.vmac.giphy.test.commons.trendingGifsDto)
    }
}