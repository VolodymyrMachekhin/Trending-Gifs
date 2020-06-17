package com.vmac.giphy.common

import com.vmac.giphy.common.utils.rx.LoadingDelegate
import com.vmac.giphy.domain.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class TestLoadingDelegate : LoadingDelegate {
    override fun <T> Single<T>.connectLoadingIndicator(onStarted: () -> Unit, onFinished: () -> Unit): Single<T> {
        onStarted()
        onFinished()
        return this
    }
}