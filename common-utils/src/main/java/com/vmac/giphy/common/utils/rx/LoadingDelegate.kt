package com.vmac.giphy.common.utils.rx

import io.reactivex.Single

interface LoadingDelegate {

    fun <T> Single<T>.connectLoadingIndicator(
        onStarted: () -> Unit = {},
        onFinished: () -> Unit = {}
    ): Single<T>
}