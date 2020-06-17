package com.vmac.giphy.ui

import com.vmac.giphy.R
import com.vmac.giphy.common.utils.ui.BaseFragment
import com.vmac.giphy.databinding.FragmentTrendingBinding
import com.vmac.giphy.ui.adapter.GiphyListAdapter
import javax.inject.Inject

class TrendingGifsFragment: BaseFragment<TrendingViewModel, FragmentTrendingBinding>(
    layoutIdRes = R.layout.fragment_trending,
    viewModelClass = TrendingViewModel::class.java
) {

    @Inject
    lateinit var adapter: GiphyListAdapter

    @Inject
    lateinit var bindingProvider: GiphyListBindingProvider

    override fun performInjection() {
        MainActivity.mainComponent.inject(this)
    }

    override fun bindingCreated(binding: FragmentTrendingBinding) {
        binding.viewModel = viewModel
        binding.adapter = adapter
        binding.itemBinding = bindingProvider.get()
    }
}