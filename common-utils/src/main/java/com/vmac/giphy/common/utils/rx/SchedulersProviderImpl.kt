package com.vmac.giphy.common.utils.rx

import com.vmac.giphy.domain.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulersProviderImpl @Inject constructor() :
    SchedulersProvider {

    override val io: Scheduler get() = Schedulers.io()

    override val computation: Scheduler get() = Schedulers.computation()

    override val ui: Scheduler get() = AndroidSchedulers.mainThread()
}