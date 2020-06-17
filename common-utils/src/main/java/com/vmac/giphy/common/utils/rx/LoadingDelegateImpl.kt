package com.vmac.giphy.common.utils.rx

import com.vmac.giphy.domain.SchedulersProvider
import io.reactivex.Single
import javax.inject.Inject

class LoadingDelegateImpl @Inject constructor(
    private val schedulersProvider: SchedulersProvider
): LoadingDelegate {

    override fun <T> Single<T>.connectLoadingIndicator(
        onStarted: () -> Unit,
        onFinished: () -> Unit
    ): Single<T> {
        return this
            .subscribeOn(schedulersProvider.io)
            .observeOn(schedulersProvider.ui)
            .doOnSubscribe { onStarted() }
            .doOnSuccess { onFinished() }
            .doOnError { onFinished() }
    }
}