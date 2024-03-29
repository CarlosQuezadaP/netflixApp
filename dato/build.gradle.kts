plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdkVersion(appdependencies.Versions.AndroidV.compileSdkVersion)
    buildToolsVersion = appdependencies.Versions.AndroidV.buildToolsVersion

    defaultConfig {
        minSdkVersion(appdependencies.Versions.AndroidV.minSdkVersion)
        targetSdkVersion(appdependencies.Versions.AndroidV.targetSdkVersion)
        versionCode = appdependencies.Versions.AndroidV.versionCode
        versionName = appdependencies.Versions.AndroidV.versionName
        buildConfigField("String", "SERVER_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "ApiKey", "\"026a257e7842ac9cac1fa627496b1468\"")
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
    implementation(appdependencies.Deps.Retrofit.core)
    implementation(appdependencies.Deps.Retrofit.gson)
    implementation(appdependencies.Deps.Okhttp.okhttp)
    implementation(appdependencies.Deps.Okhttp.logging)
    implementation(appdependencies.Deps.Coroutine.coroutines_android)
    implementation(appdependencies.Deps.Coroutine.coroutines_core)
    implementation(appdependencies.Deps.Koin.koin)
    api(project(":core"))
    api(project(":usecases"))
}