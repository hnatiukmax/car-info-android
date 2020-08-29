package com.sectumsempra.carinfo.presentation.pages.welcome

import androidx.lifecycle.ViewModel
import com.sectumsempra.carinfo.domain.entity.AuthProvider
import com.sectumsempra.carinfo.presentation.common.ActionLiveData

internal class WelcomeActivityViewModel : ViewModel() {

    val onOpenSignInPage = ActionLiveData<Unit>()

    fun onSignInClick() {
        onOpenSignInPage.call()
    }

    fun onSkipNowClick() {
        //TODO to main screen.
    }

    fun onSocialAuthClick(authProvider: AuthProvider) {
        //TODO call social provider to get token
    }
}