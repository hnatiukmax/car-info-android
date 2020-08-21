package com.sectumsempra.carinfo.data.network.services

import com.sectumsempra.carinfo.BuildConfig

internal val API get() = "/api/$API_VERSION"
internal val PUB get() = "/pub/$API_VERSION"

private val API_VERSION get() = BuildConfig.API_VERSION