package com.sectumsempra.carinfo.presentation.pages.authentication.register

import androidx.lifecycle.MutableLiveData
import com.sectumsempra.carinfo.domain.repository.AuthRepository
import com.sectumsempra.carinfo.presentation.common.ActionLiveData
import com.sectumsempra.carinfo.presentation.pages.base.BaseViewModel

internal class RegisterFragmentViewModel(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    val onRegister = ActionLiveData<Unit>()

    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val userNameHasError = MutableLiveData<Boolean>()
    val emailHasError = MutableLiveData<Boolean>()
    val passwordHasError = MutableLiveData<Boolean>()

    fun onRegisterClick() {
        //TODO make api request for registration
    }
}