package com.vmac.giphy.ui

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.vmac.giphy.common.TestLoadingDelegate
import com.vmac.giphy.common.utils.rx.LoadingDelegate
import com.vmac.giphy.domain.GifRepository
import com.vmac.giphy.domain.logging.Logger
import com.vmac.giphy.domain.model.Gif
import com.vmac.giphy.domain.model.TrendingGifs
import com.vmac.giphy.test.commons.trendingGifs
import com.vmac.giphy.ui.adapter.GiphyListItem
import io.reactivex.Single
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TrendingViewModelTest {

    private val expectedError: Throwable = mock()
    private val repository: GifRepository = mock()

    private val logger: Logger = mock()
    private val loadingDelegate: LoadingDelegate = TestLoadingDelegate()

    private fun createViewModel(): TrendingViewModel {
        return TrendingViewModel(
            repository = repository,
            logger = logger,
            loadingDelegate = loadingDelegate
        )
    }

    @Test
    fun `when init should load and display result`() {
        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(Single.just(trendingGifs))
        val viewModel = createViewModel()

        verify(repository)
            .getTrendingGifs(
                offset = 0
            )

        assertEquals(trendingGifs.items.size + 1, viewModel.giphyListItems.size)
        assertEquals(trendingGifs.items[0], viewModel.itemAt(0))
        assertEquals(GiphyListItem.LoadMore, viewModel.giphyListItems[1])
    }

    @Test
    fun `when init and error should log error`() {

        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(Single.error(expectedError))
        createViewModel()

        verify(logger).e(
            throwable = expectedError,
            message = "Error while initial loading"
        )
    }

    @Test
    fun `when setup called and empty result should handle empty result case can't load more`() {
        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(
            Single.just(
                TrendingGifs(
                    items = listOf(),
                    totalTrendingCount = 0
                )
            )
        )
        createViewModel()

        verify(repository)
            .getTrendingGifs(
                offset = 0
            )

        verify(logger).e(
            message = "Should never happen"
        )
    }

    @Test
    fun `when loading more and items are not empty should load more`() {
        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(Single.just(trendingGifs))
        whenever(
            repository.getTrendingGifs(offset = 1)
        ).thenReturn(Single.just(trendingGifs))
        val viewModel = createViewModel()

        viewModel.loadMore.invoke()
        verify(repository)
            .getTrendingGifs(
                offset = 0
            )
        verify(repository)
            .getTrendingGifs(
                offset = 1
            )

        assertEquals(2 * trendingGifs.items.size + 1, viewModel.giphyListItems.size)
        assertEquals(trendingGifs.items[0], viewModel.itemAt(0))
        assertEquals(trendingGifs.items[0], viewModel.itemAt(1))
        assertEquals(GiphyListItem.LoadMore, viewModel.giphyListItems[2])
    }

    @Test
    fun `when loading more and received empty list should stop loading`() {
        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(
            Single.just(trendingGifs)
        )
        whenever(
            repository.getTrendingGifs(offset = 1)
        ).thenReturn(
            Single.just(
                TrendingGifs(
                    items = listOf(),
                    totalTrendingCount = 0
                )
            )
        )
        val viewModel = createViewModel()


        viewModel.loadMore.invoke()
        viewModel.loadMore.invoke()
        verify(repository).getTrendingGifs(offset = 0)
        verify(repository, times(1)).getTrendingGifs(offset = 1)


        assertEquals(1, viewModel.giphyListItems.size)
        assertEquals(trendingGifs.items[0], viewModel.itemAt(0))
    }

    @Test
    fun `when loading more error should log error`() {
        whenever(
            repository.getTrendingGifs(offset = 0)
        ).thenReturn(
            Single.just(trendingGifs)
        )
        whenever(
            repository.getTrendingGifs(offset = 1)
        ).thenReturn(
            Single.error(expectedError)
        )
        createViewModel().loadMore.invoke()
        verify(logger).e(
            throwable = expectedError,
            message = "Error while loading more"
        )
    }

    private fun TrendingViewModel.itemAt(index: Int): Gif {
        return (giphyListItems[index] as GiphyListItem.DisplayGiphy).gif
    }
}