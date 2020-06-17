package com.vmac.giphy.ui.dataBinding

import com.vmac.giphy.ui.image.ImageLoader

class AppDataBindingComponent(
    private val imageLoader: ImageLoader
) : androidx.databinding.DataBindingComponent {

    override fun getAppBindings(): AppBindings {
        return AppBindings(imageLoader = imageLoader)
    }
}