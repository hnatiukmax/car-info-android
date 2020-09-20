package com.sectumsempra.carinfo.data.network.client

import com.sectumsempra.carinfo.data.network.services.AuthenticationApiService
import com.sectumsempra.carinfo.data.network.services.CarInfoService

internal val RestClient.authenticationService
    get() = retrofit.create(AuthenticationApiService::class.java)

internal val RestClient.carInfoService
    get() = retrofit.create(CarInfoService::class.java)