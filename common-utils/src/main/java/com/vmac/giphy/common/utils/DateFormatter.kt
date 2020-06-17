package com.vmac.giphy.common.utils

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {

    private val isoDateFormatter: SimpleDateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)
    private val displayDateFormat: SimpleDateFormat =
        SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault())

    fun toDisplayDate(isoDate: String): String {
        return isoDateFormatter.parse(isoDate)?.let {
            displayDateFormat.format(it)
        } ?: ""
    }
}