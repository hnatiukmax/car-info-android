package com.sectumsempra.carinfo.data.network.services

import com.sectumsempra.carinfo.data.network.request.authentication.EmailLoginRequestBody
import com.sectumsempra.carinfo.data.network.request.authentication.EmailRegisterRequestBody
import com.sectumsempra.carinfo.data.network.request.authentication.SocialAuthenticationRequestBody
import com.sectumsempra.carinfo.data.network.responses.AuthenticationNT
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthenticationApiService {

    @POST("$PUB/auth/register")
    suspend fun register(@Body body: EmailRegisterRequestBody): AuthenticationNT

    @POST("$PUB/auth/login")
    suspend fun login(@Body body: EmailLoginRequestBody): AuthenticationNT

    @POST("$PUB/auth/social-register")
    suspend fun socialRegister(@Body body: SocialAuthenticationRequestBody): AuthenticationNT

    @POST("$PUB/auth/social-login")
    suspend fun socialLogin(@Body body: SocialAuthenticationRequestBody): AuthenticationNT
}