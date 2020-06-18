package com.vmac.giphy.ui.dataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.vmac.giphy.ui.image.ImageLoader

class AppBindings(
    private val imageLoader: ImageLoader
) {

    @BindingAdapter("giphyUrl")
    fun ImageView.loadGiphyThumbnail(url: String) {
        imageLoader.loagGiphyThumbnail(
            url = url,
            target = this
        )
    }
}