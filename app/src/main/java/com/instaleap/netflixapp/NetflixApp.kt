package com.instaleap.netflixapp

import android.app.Application
import com.instaleap.dato.di.dtoConverterModule
import com.instaleap.dato.di.movieDataSourceModule
import com.instaleap.dato.di.movieRepositoryModule
import com.instaleap.dato.di.networkModule
import com.instaleap.hardware.di.connectivityModule
import com.instaleap.netflixapp.di.homeViewModelModule
import com.instaleap.usecases.di.usescase_module
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

class NetflixApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NetflixApp)
            fragmentFactory()
            modules(
                listOf(
                    dtoConverterModule,
                    movieDataSourceModule,
                    networkModule,
                    connectivityModule,
                    usescase_module,
                    homeViewModelModule,
                    movieRepositoryModule
                )
            )
        }
    }

}