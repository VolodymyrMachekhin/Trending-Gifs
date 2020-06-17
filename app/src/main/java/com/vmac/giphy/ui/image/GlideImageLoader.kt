package com.vmac.giphy.ui.image

import android.graphics.Color
import android.widget.ImageView
import com.avatarfirst.avatargenlib.AvatarConstants
import com.avatarfirst.avatargenlib.AvatarGenerator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.vmac.giphy.R
import javax.inject.Inject
import javax.inject.Singleton

class GlideImageLoader @Inject constructor() : ImageLoader {



    override fun loadUserAvatar(
        url: String?,
        target: ImageView,
        userNamePlaceHolder: String
    ) {

        val placeHolderDrawable = AvatarGenerator.avatarImage(
            context = target.context,
            size = target.resources.getDimensionPixelSize(R.dimen.avatar_size),
            shape = AvatarConstants.CIRCLE,
            name = userNamePlaceHolder
        )

        if (url == null) {
            target.setImageDrawable(placeHolderDrawable)
        } else {
            Glide.with(target.context)
                .load(url)
                .placeholder(placeHolderDrawable)
                .circleCrop()
                .into(target)
        }
    }

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