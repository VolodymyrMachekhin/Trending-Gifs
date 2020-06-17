package com.vmac.giphy.ui.dataBinding

import android.widget.ImageView
import com.vmac.giphy.ui.image.ImageLoader
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import java.util.UUID

class AppBindingsTest {

    @Test
    fun `when loadUserAvatar should call imageLoader loadUserAvatar`() {
        val imageLoader: ImageLoader = mock()
        AppBindings(imageLoader = imageLoader).apply {

            val url = UUID.randomUUID().toString()
            val name = UUID.randomUUID().toString()
            val imageView: ImageView = mock()
            imageView.loadUserAvatar(
                url = url,
                userNamePlaceHolder = name
            )

            verify(imageLoader).loadUserAvatar(
                url = url,
                target = imageView,
                userNamePlaceHolder = name
            )
        }
    }

    @Test
    fun `when loadGiphyThumbnail should call imageLoader loagGiphyThumbnail`() {
        val imageLoader: ImageLoader = mock()
        AppBindings(imageLoader = imageLoader).apply {

            val url = UUID.randomUUID().toString()
            val imageView: ImageView = mock()
            imageView.loadGiphyThumbnail(
                url = url
            )

            verify(imageLoader).loagGiphyThumbnail(
                url = url,
                target = imageView
            )
        }
    }
}