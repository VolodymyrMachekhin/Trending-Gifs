package com.vmac.giphy.ui.adapter

import com.vmac.giphy.domain.model.Gif

sealed class GiphyListItem {

    data class DisplayGiphy(
        val gif: Gif
    ) : GiphyListItem()

    object LoadMore : GiphyListItem()
}