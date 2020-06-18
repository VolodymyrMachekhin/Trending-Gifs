package com.vmac.giphy.ui.image

import android.widget.ImageView

interface ImageLoader {

    fun loagGiphyThumbnail(
        url: String,
        target: ImageView
    )
}