package com.sectumsempra.carinfo.data.network.client

import com.sectumsempra.carinfo.data.network.services.AuthenticationApiService

internal val RestClient.authenticationService
    get() = retrofit.create(AuthenticationApiService::class.java)