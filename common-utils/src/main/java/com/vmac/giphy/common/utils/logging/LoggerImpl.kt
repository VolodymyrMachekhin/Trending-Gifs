package com.vmac.giphy.common.utils.logging

import android.util.Log
import com.vmac.giphy.common.utils.BuildConfig
import com.vmac.giphy.domain.logging.Logger
import javax.inject.Inject

class LoggerImpl @Inject constructor() : Logger {

    override fun e(throwable: Throwable?, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, message, throwable)
        }
    }

    override fun d(throwable: Throwable?, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message, throwable)
        }
    }

    companion object {
        private const val TAG: String = "AppLogger"
    }
}