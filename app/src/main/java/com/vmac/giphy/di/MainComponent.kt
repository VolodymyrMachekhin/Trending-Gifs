package com.vmac.giphy.di

import com.vmac.giphy.ui.TrendingGifsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UtilsModule::class,
        RepositoryModule::class,
        RetrofitModule::class
    ]
)
interface MainComponent {

    fun inject(fragment: TrendingGifsFragment)
}