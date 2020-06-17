package com.vmac.giphy.ui.dataBinding

import android.view.View
import android.widget.RatingBar
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

@BindingAdapter("ratingColor")
fun RatingBar.setRatingColor(@ColorRes colorRes: Int) {
    progressDrawable.setTint(ContextCompat.getColor(context, colorRes))
}

@BindingAdapter("visible")
fun View.visibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

private const val SHORT_DELAY_MS: Long = 200

@BindingAdapter("postVisible")
fun View.postVisibleOrGone(visible: Boolean) {
    val newVisibility = if (visible) View.VISIBLE else View.GONE
    postDelayed({
        visibility = newVisibility
    }, SHORT_DELAY_MS)
}

@BindingAdapter("onBottomReached", "onBottomReachedThreshold")
fun RecyclerView.onBottomReached(action: () -> Unit, threshold: Int) {
    addOnScrollListener(BottomReachedListener(threshold, action))
}

class BottomReachedListener(
    private val threshold: Int,
    private val action: () -> Unit
) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

        val layoutManager = recyclerView.layoutManager

        val lastVisibleItem = when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is StaggeredGridLayoutManager -> layoutManager.findLastCompletelyVisibleItemPositions(
                null
            ).last()
            else -> throw IllegalArgumentException("Not supported for custom layout manager")
        }

        val totalItemCount = layoutManager.itemCount
        if (totalItemCount - lastVisibleItem <= threshold) {
            recyclerView.post {
                action()
            }
        }
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
    }
}