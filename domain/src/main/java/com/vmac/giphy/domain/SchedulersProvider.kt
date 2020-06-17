package com.vmac.giphy.domain

import io.reactivex.Scheduler

interface SchedulersProvider {

    val io: Scheduler

    val computation: Scheduler

    val ui: Scheduler
}