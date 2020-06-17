package com.vmac.giphy.ui.image

import android.widget.ImageView

interface ImageLoader {

    fun loadUserAvatar(
        url: String?,
        target: ImageView,
        userNamePlaceHolder: String
    )

    fun loagGiphyThumbnail(
        url: String,
        target: ImageView
    )
}