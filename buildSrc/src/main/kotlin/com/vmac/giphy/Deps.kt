package com.vmac.giphy

import com.vmac.giphy.Versions.androidxAppCompatVer
import com.vmac.giphy.Versions.androidxConstraintlayoutVer
import com.vmac.giphy.Versions.androidxFragmentVer
import com.vmac.giphy.Versions.bindingCollectionVer
import com.vmac.giphy.Versions.daggerVer
import com.vmac.giphy.Versions.glideVer
import com.vmac.giphy.Versions.kotlinVersion
import com.vmac.giphy.Versions.okhttpVer
import com.vmac.giphy.Versions.retrofitVer

object Versions {
    val appVerCode = 1
    val appVerName = "1.0"

    val kotlinVersion = "1.3.72"
    val androidGradlePluginVer = "4.0.0"

    val compileSdkVer = 29
    val targetSdkVer = 29
    val buildToolsVer = "29.0.2"
    val minSdkVer = 21

    val bindingCollectionVer = "3.2.0"
    val retrofitVer = "2.9.0"
    val daggerVer = "2.28"
    val glideVer = "4.11.0"
    val okhttpVer = "4.0.0"

    val androidxAppCompatVer = "1.1.0"
    val androidxFragmentVer = "1.2.4"
    val androidxConstraintlayoutVer = "1.1.3"
}

object Deps {
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    val androidxAppCompat = "androidx.appcompat:appcompat:$androidxAppCompatVer"
    val androidxCore = "androidx.core:core-ktx:1.2.0"
    val androidxConstraintlayout =
        "androidx.constraintlayout:constraintlayout:$androidxConstraintlayoutVer"
    val androidxFragment = "androidx.fragment:fragment-ktx:$androidxFragmentVer"


    val okhttp3 = "com.squareup.okhttp3:okhttp:$okhttpVer"

    val dagger = "com.google.dagger:dagger:$daggerVer"

    val retrofit2 = "com.squareup.retrofit2:retrofit:$retrofitVer"
    val retrofit2RxAdapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVer"
    val retrofit2Moshi = "com.squareup.retrofit2:converter-moshi:$retrofitVer"

    val glide = "com.github.bumptech.glide:glide:$glideVer"

    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"

    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.7.2"


    val rxJava = "io.reactivex.rxjava2:rxjava:2.2.19"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    val bindingcollectionadapter =
        "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter:$bindingCollectionVer"
    val bindingcollectionadapterRecyclerview =
        "me.tatarka.bindingcollectionadapter2:bindingcollectionadapter-recyclerview:$bindingCollectionVer"

    val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVer"
    val glideCompiler = "com.github.bumptech.glide:compiler:$glideVer"
}