package com.vmac.giphy

import org.gradle.api.Project

fun Project.isIdeBuild(): Boolean {
    return project.properties["android.injected.invoked.from.ide"] == "true"
}

fun Project.isReleaseBuild(): Boolean {
    return gradle.startParameter.taskRequests.toString().contains("Release")
}

inline fun <reified T> cast(from: Any?): T? = from as? T

inline fun <reified T> Project.getProperty(key: String): T? {
    return if (project.hasProperty(key)) {
        val property = project.property(key)

        cast<T>(property)
    } else null
}