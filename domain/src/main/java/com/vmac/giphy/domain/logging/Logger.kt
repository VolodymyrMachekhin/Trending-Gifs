package com.vmac.giphy.domain.logging

interface Logger {

    fun e(throwable: Throwable? = null, message: String)

    fun d(throwable: Throwable? = null, message: String)
}