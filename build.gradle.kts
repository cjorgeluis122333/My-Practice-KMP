plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false

    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.room) apply false

    alias(libs.plugins.kotlin.serialization) apply false
    //alias(libs.plugins.kotlin.parcelize) apply false
    //Create for the plugin
    //alias(libs.plugins.kotlinAndroid).apply(false)
    //alias(libs.plugins.android.kotlin.multiplatform.library) apply false

}