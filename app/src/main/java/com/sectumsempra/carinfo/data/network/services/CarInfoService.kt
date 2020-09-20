package com.sectumsempra.carinfo.data.network.services

import com.sectumsempra.carinfo.data.network.responses.CarInfoNT
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CarInfoService {

    @GET("$API/car-info/{number}")
    suspend fun getCarInfo(@Path("number") number: String): CarInfoNT
}