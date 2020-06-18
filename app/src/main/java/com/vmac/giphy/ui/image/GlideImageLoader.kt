package com.vmac.giphy.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import javax.inject.Inject

class GlideImageLoader @Inject constructor() : ImageLoader {

    override fun loagGiphyThumbnail(url: String, target: ImageView) {
        Glide.with(target.context)
            .load(url)
            .transition(crossFadeTransitionOptions)
            .into(target)
    }

    companion object {
        private const val CROSSFADE_DURATION_MS: Int = 200

        private val crossFadeTransitionOptions: DrawableTransitionOptions =
            DrawableTransitionOptions.withCrossFade(CROSSFADE_DURATION_MS)
    }
}