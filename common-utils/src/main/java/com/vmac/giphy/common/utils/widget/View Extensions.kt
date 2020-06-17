package com.vmac.giphy.common.utils.widget

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.doOnNextLayout

fun View.doOnLayout(action: (View) -> Unit) {
    if (ViewCompat.isLaidOut(this) && !isLayoutRequested) {
        action(this)
    } else {
        doOnNextLayout {
            action(it)
        }
    }
}