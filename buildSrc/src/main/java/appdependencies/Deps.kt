package appdependencies

object Deps {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.Core.core_ktx}"

    object Coroutine {
        const val coroutines_core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_core}"

        const val coroutines_android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_core}"
    }


    const val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constrainLayout}"

    const val material = "com.google.android.material:material:${Versions.material}"

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

    object Okhttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
        const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    }


    object Lifecycle {
        const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
        const val kapt_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

        //const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${lifecycle}"
        const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

        // kotlin live data extensions
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

        // alternately - if using Java8, use the following instead of lifecycle-compiler
        const val common = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

        // view model saved state handler
        const val savedStateViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.savedstate}"
    }


    object Tests {
        const val junit = "junit:junit:${Versions.junit}"
        const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext}"
        const val test_rules = "androidx.test:rules:${Versions.test_rules}"
        const val test_runner = "androidx.test:runner:${Versions.test_rules}"
        const val test_espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val espresso_espresso = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    }

    object Mockito {
        const val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
        const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito_inline}"
    }

    object Core {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompatX}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.appCoreX}"
        const val navigationFragmentKtx =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.fragment}"
        const val navigationUiKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.ui}"

        const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
        const val swipeRefreshLayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
        const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"
    }

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"


}

