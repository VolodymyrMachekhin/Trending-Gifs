package com.vmac.giphy.di

import com.vmac.giphy.domain.GifRepository
import com.vmac.giphy.network.repository.NetworkGifRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(
        networkGifRepository: NetworkGifRepository
    ): GifRepository
}