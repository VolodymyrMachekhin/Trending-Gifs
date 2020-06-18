buildscript {

    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.3.72")
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

gradlePlugin {
    plugins {
        register("GiphyPlugin") {
            id = "GiphyPlugin"
            implementationClass = "com.vmac.giphy.GiphyPlugin"
        }
    }
}

dependencies {
    implementation(gradleApi())

    implementation("com.android.tools.build:gradle:4.0.0")
    implementation(  "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
}