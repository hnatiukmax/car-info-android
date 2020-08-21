package com.sectumsempra.carinfo.data.network.client

import com.sectumsempra.carinfo.data.network.services.AuthenticationService

internal val RestClient.authenticationService
    get() = retrofit.create(AuthenticationService::class.java)