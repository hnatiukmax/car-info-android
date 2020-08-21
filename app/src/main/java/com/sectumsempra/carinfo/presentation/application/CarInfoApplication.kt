package com.sectumsempra.carinfo.presentation.application

import android.app.Application
import com.sectumsempra.carinfo.presentation.di.provideModules
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

internal class CarInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initServiceLocator()
    }

    private fun initServiceLocator() {
        startKoin {
            logger(AndroidLogger())
            modules(*provideModules())
        }
    }
}