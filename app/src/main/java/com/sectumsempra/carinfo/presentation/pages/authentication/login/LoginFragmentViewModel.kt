package com.sectumsempra.carinfo.presentation.pages.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sectumsempra.carinfo.domain.extensions.doOnError
import com.sectumsempra.carinfo.domain.extensions.doOnSuccess
import com.sectumsempra.carinfo.domain.repository.AuthRepository
import com.sectumsempra.carinfo.presentation.common.ActionLiveData
import com.sectumsempra.carinfo.presentation.common.not
import com.sectumsempra.carinfo.presentation.common.valueOrEmpty
import com.sectumsempra.carinfo.presentation.common.withProgress
import com.sectumsempra.carinfo.presentation.pages.base.BaseViewModel
import kotlinx.coroutines.launch

internal class LoginFragmentViewModel(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    val onLogin = ActionLiveData<Unit>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val emailHasError = MutableLiveData<Boolean>()
    val passwordHasError = MutableLiveData<Boolean>()

    fun onLogInClick() {
        if (!isAllFieldsValid()) return

        onCloseKeyboard.call()
        viewModelScope.launch {
            isProgressVisible.withProgress {
                authRepository.login(email.valueOrEmpty, password.valueOrEmpty)
                    .doOnSuccess { onShowMessage.value = it.name }
                    .doOnError { onShowError.value = it }
            }
        }
    }

    private fun isAllFieldsValid() : Boolean {
        emailHasError.value = email.value.isNullOrEmpty()
        passwordHasError.value = password.value.isNullOrEmpty()

        return !emailHasError && !passwordHasError
    }
}