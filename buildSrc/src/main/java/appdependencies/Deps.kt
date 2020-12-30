package appdependencies

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.Core.core_ktx}"

    const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constrainLayout}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val junit = "junit:junit:4.+:${Versions.Test.junit}}"
    const val junit2 = "androidx.test.ext:junit:1.1.2:${Versions.Test.junit_test}"
    const val espresso = "androidx.test.espresso:espresso-core:3.3.0:${Versions.Test.espresso}"

    object Koin {
        const val koin = "org.koin:koin-android:${Versions.koin}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
        const val koinFragment = "org.koin:koin-androidx-fragment:${Versions.koin}"
        const val koinScope = "org.koin:koin-androidx-scope:${Versions.koin}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

}

