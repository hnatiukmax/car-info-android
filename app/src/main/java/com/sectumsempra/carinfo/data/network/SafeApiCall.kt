package com.sectumsempra.carinfo.data.network

import com.sectumsempra.carinfo.data.network.responses.Response
import com.sectumsempra.carinfo.data.network.responses.ResultResponse
import com.sectumsempra.carinfo.domain.core.AppException
import com.sectumsempra.carinfo.domain.core.Result
import com.sectumsempra.carinfo.presentation.common.getError

@Suppress("UNCHECKED_CAST")
internal suspend fun <R : Response<T>, T> safeApiCall(call: suspend () -> R): Result<T, AppException> {
    return try {
        when (val callResponse = call.invoke()) {
            is ResultResponse<*> -> Result.Success(callResponse.data as T)
            else -> Result.Error(AppException.UnknownApiResponse())
        }
    } catch (exception: Exception) {
        Result.Error(getError(exception))
    }
}