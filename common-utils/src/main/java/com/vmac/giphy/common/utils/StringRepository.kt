package com.vmac.giphy.common.utils

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

class StringRepository @Inject constructor(
    private val context: Context
) {

    fun getString(@StringRes intRes: Int, vararg formatArgs: Any): String {
        return context.getString(intRes, *formatArgs)
    }
}