plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
//    id("maven-publish")
}
//afterEvaluate {
//    publishing {
//        publications {
//            create<MavenPublication>("release") {
//                groupId = "com.example.material3theme"
//                artifactId = "material3theme"
//                version = "1.0.0"
//            }
//        }
//    }
//}
ext {
    set("PUBLISH_GROUP_ID", "com.example.material3theme")
    set("PUBLISH_ARTIFACT_ID", "materialtheme")
    set("PUBLISH_VERSION", version)
    set("PUBLISH_DESCRIPTION", "Material 3 Theme Analyzer for Android")
    set("PUBLISH_URL", "https://github.com/InfantAjith96/Material3-Theme-Analyzer")
    set("PUBLISH_LICENSE_NAME", "Apache-2.0")
//    set("PUBLISH_LICENSE_URL", "https://www.apache.org/licenses/LICENSE-2.0.txt")
    set("PUBLISH_DEVELOPER_ID", "infantajith1996")
    set("PUBLISH_DEVELOPER_NAME", "Ajith")
    set("PUBLISH_DEVELOPER_EMAIL", "infantajith1996@gmail.com")
    set("PUBLISH_SCM_CONNECTION", "scm:git:https://github.com/InfantAjith96/Material3-Theme-Analyzer.git")
    set("PUBLISH_SCM_DEVELOPER_CONNECTION", "scm:git:https://github.com/InfantAjith96/Material3-Theme-Analyzer.git")
    set("PUBLISH_SCM_URL", "https://github.com/InfantAjith96/Material3-Theme-Analyzer")
}
//apply(from = "${rootProject.projectDir}/scripts/publish.gradle")
//https://raw.githubusercontent.com/material3theme/materialtheme/main/publish-module.gradle

android {
    namespace = "com.example.materialtheme"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}