package com.sectumsempra.carinfo.presentation.di.modules

import com.sectumsempra.carinfo.data.network.client.OkHttpClientFactory
import com.sectumsempra.carinfo.data.network.client.RestClient
import com.sectumsempra.carinfo.data.network.client.authenticationService
import com.sectumsempra.carinfo.data.network.converters.ConverterFactoryProvider
import com.sectumsempra.carinfo.data.network.converters.MoshiConverterFactoryProvider
import com.sectumsempra.carinfo.data.network.services.AuthenticationApiService
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module

internal val networkModule = module {
    single<ConverterFactoryProvider> { MoshiConverterFactoryProvider() }
    single { OkHttpClientFactory() }
    single { buildRestClient() }
    includeServiceDependencies()
}

/**
 * Api service dependencies.
 */
private fun Module.includeServiceDependencies() {
    single<AuthenticationApiService> { get<RestClient>().authenticationService }
}

private fun Scope.buildRestClient() = RestClient(
    baseUrl = get(named(AppConstant.BASE_URL)),
    okHttpClient = get<OkHttpClientFactory>().buildOkHttpClient(),
    converterFactoryProvider = get()
)