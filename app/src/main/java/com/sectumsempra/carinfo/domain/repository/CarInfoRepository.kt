package com.sectumsempra.carinfo.domain.repository

import com.sectumsempra.carinfo.data.network.safeApiCall
import com.sectumsempra.carinfo.data.network.services.CarInfoService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class CarInfoRepository(private val carInfoService: CarInfoService) {

    suspend fun getCarInfoByNumber(number: String) = withContext(Dispatchers.IO) {
        safeApiCall { carInfoService.getCarInfo(number) }
    }
}