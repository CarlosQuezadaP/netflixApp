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
}