package com.sectumsempra.carinfo.domain.repository

import com.sectumsempra.carinfo.data.network.request.authentication.EmailLoginRequestBody
import com.sectumsempra.carinfo.data.network.responses.asDomainEntity
import com.sectumsempra.carinfo.data.network.safeApiCall
import com.sectumsempra.carinfo.data.network.services.AuthenticationApiService
import com.sectumsempra.carinfo.domain.core.AppException
import com.sectumsempra.carinfo.domain.core.Result
import com.sectumsempra.carinfo.domain.entity.AuthResult
import com.sectumsempra.carinfo.domain.extensions.mapOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class AuthRepository(
    private val authApiService: AuthenticationApiService
) {

    suspend fun login(email: String, password: String): Result<AuthResult, AppException> = withContext(Dispatchers.IO) {
        safeApiCall { authApiService.login(EmailLoginRequestBody(email, password)) }
            .mapOnSuccess { it.asDomainEntity }
    }
}