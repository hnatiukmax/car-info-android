package com.sectumsempra.carinfo.presentation.di

import com.sectumsempra.carinfo.presentation.di.modules.applicationIdentifiersDependencies
import com.sectumsempra.carinfo.presentation.di.modules.networkModule
import com.sectumsempra.carinfo.presentation.di.modules.repositoryModule
import com.sectumsempra.carinfo.presentation.di.modules.viewModelModule

internal fun provideModules() = arrayOf(
    applicationIdentifiersDependencies,
    networkModule,
    repositoryModule,
    viewModelModule
)