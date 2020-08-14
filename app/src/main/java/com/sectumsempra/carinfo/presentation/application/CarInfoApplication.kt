package com.sectumsempra.carinfo.presentation.application

import android.app.Application
import com.sectumsempra.carinfo.presentation.di.modules.viewModelModule
import org.koin.core.context.startKoin

internal class CarInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initServiceLocator()
    }

    private fun initServiceLocator() {
        startKoin {
            modules(viewModelModule)
        }
    }
}