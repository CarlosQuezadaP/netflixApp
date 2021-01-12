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
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
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
    implementation(Deps.Koin.koin)
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation(Deps.Core.navigationFragmentKtx)
    implementation(Deps.Core.navigationUiKtx)
    implementation(Deps.Core.constraintlayout)
    implementation(Deps.Lifecycle.livedataKtx)
    implementation(Deps.Lifecycle.viewmodelKtx)
    implementation(Deps.Lifecycle.savedStateViewModel)
    implementation(Deps.Lifecycle.extensions)
    implementation(Deps.Lifecycle.common)
    implementation(Deps.Lifecycle.runtime)
    kapt(Deps.Lifecycle.kapt_compiler)
    kapt(Deps.glide_annotationProcessor)
    api(project(":core"))
    api(project(":dato"))
    api(project(":hardware"))
    api(project(":usecases"))


    androidTestImplementation(Deps.Tests.test_ext_junit)
    androidTestImplementation(Deps.Tests.junit)
    androidTestImplementation(Deps.Tests.test_rules)
    androidTestImplementation(Deps.Tests.test_runner)
    androidTestImplementation(Deps.Tests.espresso_espresso)
    androidTestImplementation(Deps.Tests.test_espresso)
    testImplementation(Deps.Mockito.mockito_inline)
    testImplementation(Deps.Mockito.mockito_core)

}