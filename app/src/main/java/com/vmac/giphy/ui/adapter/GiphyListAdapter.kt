package com.vmac.giphy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vmac.giphy.R
import com.vmac.giphy.common.utils.widget.doOnLayout
import com.vmac.giphy.ui.dataBinding.AppDataBindingComponent
import com.vmac.giphy.ui.image.ImageLoader
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter
import javax.inject.Inject

class GiphyListAdapter @Inject constructor(
    private val imageLoader: ImageLoader
) : BindingRecyclerViewAdapter<GiphyListItem>() {

    private var celWidth: Int = 0

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.doOnLayout { view ->
            celWidth = view.width / view.resources.getInteger(R.integer.list_span_count)
        }
    }

    override fun onCreateBinding(
        inflater: LayoutInflater,
        layoutId: Int,
        viewGroup: ViewGroup
    ): ViewDataBinding {
        return DataBindingUtil.inflate(
            inflater,
            layoutId,
            viewGroup,
            false,
            AppDataBindingComponent(imageLoader = imageLoader)
        )
    }

    override fun onBindBinding(
        binding: ViewDataBinding,
        variableId: Int,
        layoutRes: Int,
        position: Int,
        item: GiphyListItem?
    ) {
        val fullSpan = when (item) {
            is GiphyListItem.DisplayGiphy -> false
            is GiphyListItem.LoadMore -> true
            else -> null
        }

        fullSpan?.also {
            (binding.root.layoutParams as StaggeredGridLayoutManager.LayoutParams).isFullSpan = it
        }

        if (item is GiphyListItem.DisplayGiphy) {
            binding.root.layoutParams.width = celWidth
            binding.root.layoutParams.height = (celWidth / item.aspectRatio).toInt()
        }
        super.onBindBinding(binding, variableId, layoutRes, position, item)
    }
}

val GiphyListItem.DisplayGiphy.aspectRatio: Float
    get() {
        return gif.imageSize.width.toFloat() / gif.imageSize.height.toFloat()
    }