package com.sectumsempra.carinfo.data.network.request.authentication

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class SocialAuthenticationRequestBody(
    @Json(name = "provider")
    val email: AuthenticationProvider,
    @Json(name = "token")
    val password: String
)