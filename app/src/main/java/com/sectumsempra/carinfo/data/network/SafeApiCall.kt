package com.sectumsempra.carinfo.data.network

import com.sectumsempra.carinfo.domain.core.AppException
import com.sectumsempra.carinfo.domain.core.Result
import com.sectumsempra.carinfo.presentation.common.getError

internal suspend fun <T> safeApiCall(call: suspend () -> T): Result<T, AppException> {
    return try {
        Result.Success(call.invoke())
    } catch (exception: Exception) {
        Result.Error(getError(exception))
    }
}