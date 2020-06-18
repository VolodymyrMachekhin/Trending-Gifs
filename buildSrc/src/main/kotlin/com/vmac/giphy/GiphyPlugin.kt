package com.vmac.giphy

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.internal.Kapt3GradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

class GiphyPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        with(project) {
            plugins.apply("org.jetbrains.kotlin.android")
            plugins.apply("org.jetbrains.kotlin.kapt")

            dependencies {
                listOf(
                    Deps.kotlinStdLib,
                    Deps.rxJava,
                    Deps.rxKotlin,
                    Deps.dagger
                ).forEach {
                    add("implementation", it)
                }

                listOf(
                    Deps.daggerCompiler
                ).forEach {
                    add("kapt", it)
                }
            }

            project.plugins.all {

                when (this) {

                    is LibraryPlugin -> {
                        val extension: LibraryExtension = project.extensions.getByType(
                            LibraryExtension::class.java
                        )
                        extension.configureLibrary(project)
                    }
                    is AppPlugin -> {

                    }
                    is Kapt3GradleSubplugin -> {
                        val extension: KaptExtension =
                            project.extensions.getByType(KaptExtension::class.java)
                        extension.configureKapt(project)
                    }
                }
            }
        }
    }
}

private fun KaptExtension.configureKapt(project: Project) {
    correctErrorTypes = true
}

private fun LibraryExtension.configureLibrary(project: Project) {
    setCompileSdkVersion(Versions.compileSdkVer)
    buildToolsVersion = Versions.buildToolsVer

    buildTypes {
        maybeCreate("release").apply {
            isMinifyEnabled = false
        }

        maybeCreate("debug").apply {
            isMinifyEnabled = false
        }
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
        aidl = true
    }

    defaultConfig.apply {
        minSdkVersion(Versions.minSdkVer)
        targetSdkVersion(Versions.targetSdkVer)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}