package com.sectumsempra.carinfo.presentation.di.modules

import com.sectumsempra.carinfo.domain.repository.AuthRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    single { AuthRepository(get()) }
}