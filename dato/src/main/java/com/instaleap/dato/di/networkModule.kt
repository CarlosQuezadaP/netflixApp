package com.instaleap.dato.di

import com.instaleap.dato.BuildConfig
import com.instaleap.dato.IMovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

const val NETWORK_AVAILABLE_AGE = 60

val networkModule = module {
    val connectTimeout: Long = 10// 20s
    val readTimeout: Long = 10 // 20s

    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }

        okHttpClientBuilder.addInterceptor { chain ->
            val request = chain.request()
            val originalHttpUrl = request.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.ApiKey)
                .addQueryParameter("language", Locale.getDefault().toLanguageTag())
                .build()

            chain.proceed(
                request.newBuilder()
                    .url(url)
                    .removeHeader("Pragma")
                    .addHeader("Content-type", "application/json")
                    .addHeader("Cache-Control", "public, max-age=$NETWORK_AVAILABLE_AGE")
                    .build()
            )
        }

        okHttpClientBuilder.build()
        return okHttpClientBuilder.build()
    }

    single { provideHttpClient() }
    single<IMovieApi> {
        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
            .create(IMovieApi::class.java)

    }
}