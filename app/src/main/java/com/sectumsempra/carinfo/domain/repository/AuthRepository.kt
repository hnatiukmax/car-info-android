package com.sectumsempra.carinfo.domain.repository

import com.sectumsempra.carinfo.data.network.services.AuthenticationApiService
import com.sectumsempra.carinfo.domain.core.AppException
import com.sectumsempra.carinfo.domain.core.Result
import com.sectumsempra.carinfo.domain.entity.AuthResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class AuthRepository(
    private val authApiService: AuthenticationApiService
) {

    suspend fun login(email: String, password: String): Result<AuthResult, AppException> = withContext(Dispatchers.IO) {
        //For test
        delay(1500L)
        Result.Success(AuthResult("Arkadiy", "some token"))
//        safeApiCall { authApiService.login(EmailLoginRequestBody(email, password)) }
//            .mapOnSuccess { it.asDomainEntity }
    }
}