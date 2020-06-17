package com.vmac.giphy.domain

interface Mapper<V, K> {

    fun map(from: V): K
}