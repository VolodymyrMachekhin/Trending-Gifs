package com.vmac.giphy.common.utils.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, VD : ViewDataBinding>(
    @param:LayoutRes
    private val layoutIdRes: Int,
    private val viewModelClass: Class<VM>
) : Fragment() {

    protected lateinit var viewModel: VM
    private lateinit var binding: VD

    @Inject
    lateinit var viewModelFactory: GenericViewModelFactory<VM>

    protected abstract fun performInjection()

    protected abstract fun bindingCreated(binding: VD)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        performInjection()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutIdRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(viewModelClass)
        binding = DataBindingUtil.bind(view)!!
        bindingCreated(binding)
    }
}