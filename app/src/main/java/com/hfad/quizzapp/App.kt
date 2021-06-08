package com.hfad.quizzapp

import android.app.Application
import com.hfad.quizzapp.di.networkModule
import com.hfad.quizzapp.di.repositoryModule
import com.hfad.quizzapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(provideModules())
        }
    }

    private fun provideModules() = listOf(
        repositoryModule,
        viewModelModule,
        networkModule
    )
}
