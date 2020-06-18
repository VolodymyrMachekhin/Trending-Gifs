package com.vmac.giphy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vmac.giphy.R
import com.vmac.giphy.di.DaggerMainComponent
import com.vmac.giphy.di.MainComponent

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TrendingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = DaggerMainComponent
            .builder()
            .build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        lateinit var mainComponent: MainComponent
    }
}