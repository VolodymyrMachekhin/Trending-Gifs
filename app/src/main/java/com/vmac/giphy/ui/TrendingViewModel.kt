package com.vmac.giphy.ui

import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import com.vmac.giphy.BR
import com.vmac.giphy.common.utils.rx.LoadingDelegate
import com.vmac.giphy.common.utils.ui.BaseViewModel
import com.vmac.giphy.domain.GifRepository
import com.vmac.giphy.domain.logging.Logger
import com.vmac.giphy.domain.model.TrendingGifs
import com.vmac.giphy.ui.adapter.GiphyListItem
import com.vmac.giphy.ui.adapter.GiphyListItem.DisplayGiphy
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class TrendingViewModel @Inject constructor(
    private val repository: GifRepository,
    private val logger: Logger,
    loadingDelegate: LoadingDelegate
) : BaseViewModel(), LoadingDelegate by loadingDelegate {

    private var loadMoreDisposable: Disposable? = null
        set(value) {
            field?.dispose()
            field = value
            field?.autoDispose()
        }

    @get:Bindable
    var progressVisible: Boolean by observable(false, BR.progressVisible)

    private var loadingMoreFinished: Boolean = false

    val giphyListItems: ObservableArrayList<GiphyListItem> = ObservableArrayList()

    val loadMore: () -> Unit = {
        // We must not calculate progress item
        loadMore(offset = giphyListItems.size - 1)
    }

    init {
        initialLoad()
    }

    fun initialLoad() {
        cancelAllTasks()
        repository
            .getTrendingGifs()
            .map(::toDisplayResult)
            .connectLoadingIndicator(
                onStarted = {
                    progressVisible = true
                },
                onFinished = {
                    progressVisible = false
                }
            )
            .subscribeBy(
                onSuccess = { result ->
                    giphyListItems.clear()
                    if (result.items.isNotEmpty()) {
                        giphyListItems.addAll(result.items)
                        giphyListItems.add(GiphyListItem.LoadMore)
                    } else {
                        logger.e(message = "Should never happen")
                        loadingMoreFinished = true
                        // Show some empty list placeholder
                    }
                },
                onError = {
                    logger.e(it, "Error while initial loading")
                    // Do some error handling
                }
            ).autoDispose()
    }

    private fun loadMore(offset: Int) {
        if (
            loadMoreDisposable?.isDisposed == false ||
            giphyListItems.isEmpty() ||
            progressVisible ||
            loadingMoreFinished
        ) {
            logger.d(message = "Loading is finished or in progress")
            return
        }
        loadMoreDisposable = repository
            .getTrendingGifs(
                offset = offset
            )
            .map(::toDisplayResult)
            .connectLoadingIndicator()
            .subscribeBy(
                onSuccess = { result ->
                    if (result.items.isEmpty()) {
                        loadingMoreFinished = true
                        giphyListItems.removeAt(giphyListItems.size - 1)
                    } else {
                        giphyListItems.addAll(giphyListItems.size - 1, result.items)
                    }
                },
                onError = {
                    logger.e(it, "Error while loading more")
                    // Do some error handling
                }
            )
    }

    private fun toDisplayResult(trendingGifs: TrendingGifs): DisplayResult {
        return DisplayResult(
            items = trendingGifs.items.map(::DisplayGiphy),
            totalCount = trendingGifs.totalTrendingCount
        )
    }

    data class DisplayResult(
        val items: List<DisplayGiphy>,
        val totalCount: Int
    )
}