// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    id ("io.github.gradle-nexus.publish-plugin") version "2.0.0" apply true
}
apply(from = "${rootDir}/scripts/publish-root.gradle")