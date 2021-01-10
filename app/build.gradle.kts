import appdependencies.Builds.APP_ID
import appdependencies.Deps
import appdependencies.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Versions.AndroidV.compileSdkVersion)
    buildToolsVersion = Versions.AndroidV.buildToolsVersion

    defaultConfig {
        applicationId = APP_ID
        minSdkVersion(Versions.AndroidV.minSdkVersion)
        targetSdkVersion(Versions.AndroidV.targetSdkVersion)
        versionCode = Versions.AndroidV.versionCode
        versionName = Versions.AndroidV.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "IMAGES_URL", "\"https://image.tmdb.org/t/p/w500\"")
        buildConfigField("String", "SERVER_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "IMAGES_BACKDROP_URL", "\"https://image.tmdb.org/t/p/original\"")


    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }

        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
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
        dataBinding = true
        viewBinding = true
    }

}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")

    implementation(Deps.kotlin)
    implementation(Deps.core_ktx)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    implementation(Deps.constraintlayout)
    implementation(Deps.Koin.koinFragment)
    implementation(Deps.Koin.koinScope)
    implementation(Deps.Koin.koinViewModel)
    implementation(Deps.Coroutine.coroutines_android)
    implementation(Deps.Coroutine.coroutines_core)
    implementation(Deps.glide)
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    kapt(Deps.glide_annotationProcessor)
    implementation(Deps.Core.navigationFragmentKtx)
    implementation(Deps.Core.navigationUiKtx)
    implementation(Deps.Core.constraintlayout)

    kapt(Deps.Lifecycle.kapt_compiler)
    api(Deps.Lifecycle.livedataKtx)
    api(Deps.Lifecycle.viewmodelKtx)
    api(Deps.Lifecycle.savedStateViewModel)
    api(Deps.Lifecycle.extensions)
    api(Deps.Lifecycle.common)
    api(Deps.Lifecycle.runtime)



    implementation(appdependencies.Deps.Koin.koin)
    api(project(":core"))
    api(project(":dato"))
    api(project(":hardware"))
    api(project(":usecases"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.junit2)
    androidTestImplementation(Deps.espresso)
}