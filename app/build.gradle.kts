import appdependencies.Builds.APP_ID
import appdependencies.Deps
import appdependencies.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
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
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }

        getByName("release") {
            isMinifyEnabled = false
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
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")

    implementation(Deps.kotlin)
    implementation(Deps.core_ktx)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    implementation(Deps.constraintlayout)
    implementation(Deps.Koin.koin)
    implementation(Deps.Koin.koinFragment)
    implementation(Deps.Koin.koinScope)
    implementation(Deps.Koin.koinViewModel)
    implementation(Deps.Coroutine.coroutines_android)
    implementation(Deps.Coroutine.coroutines_core)

    implementation(Deps.Core.navigationFragmentKtx)
    implementation(Deps.Core.navigationUiKtx)
    implementation(Deps.Core.constraintlayout)

    api(project(":dato"))
    api(project(":hardware"))
    api(project(":usecases"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    testImplementation(Deps.junit)

    androidTestImplementation(Deps.junit2)
    androidTestImplementation(Deps.espresso)
}