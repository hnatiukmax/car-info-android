package com.sectumsempra.carinfo.presentation.pages.authentication.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sectumsempra.carinfo.domain.extensions.doOnError
import com.sectumsempra.carinfo.domain.extensions.doOnSuccess
import com.sectumsempra.carinfo.domain.repository.AuthRepository
import com.sectumsempra.carinfo.domain.validators.isEmailValid
import com.sectumsempra.carinfo.domain.validators.isPasswordValid
import com.sectumsempra.carinfo.domain.validators.isUsernameValid
import com.sectumsempra.carinfo.presentation.common.ActionLiveData
import com.sectumsempra.carinfo.presentation.common.not
import com.sectumsempra.carinfo.presentation.common.valueOrEmpty
import com.sectumsempra.carinfo.presentation.common.withProgress
import com.sectumsempra.carinfo.presentation.pages.base.BaseViewModel
import kotlinx.coroutines.launch

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
        if (!isAllFieldsValid()) return

        onCloseKeyboard.call()
        viewModelScope.launch {
            isProgressVisible.withProgress {
                authRepository.register(userName.valueOrEmpty, email.valueOrEmpty, password.valueOrEmpty)
                    .doOnSuccess { onShowMessage.value = it.name }
                    .doOnError { onShowError.value = it }
            }
        }
    }

    private fun isAllFieldsValid(): Boolean {
        userNameHasError.value = !userName.value.isUsernameValid
        emailHasError.value = !email.value.isEmailValid
        passwordHasError.value = !password.value.isPasswordValid

        return !userNameHasError && !emailHasError && !passwordHasError
    }
}