package com.sectumsempra.carinfo.presentation.application

import android.app.Application
import com.sectumsempra.carinfo.presentation.di.provideModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

internal class CarInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initServiceLocator()
    }

    private fun initServiceLocator() {
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CarInfoApplication)
            modules(*provideModules())
        }
    }
}