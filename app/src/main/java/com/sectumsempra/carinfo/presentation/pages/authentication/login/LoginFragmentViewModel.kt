package com.sectumsempra.carinfo.presentation.pages.authentication.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sectumsempra.carinfo.domain.extensions.doOnError
import com.sectumsempra.carinfo.domain.extensions.doOnSuccess
import com.sectumsempra.carinfo.domain.repository.AuthRepository
import com.sectumsempra.carinfo.presentation.common.ActionLiveData
import com.sectumsempra.carinfo.presentation.common.withProgress
import com.sectumsempra.carinfo.presentation.pages.base.BaseViewModel
import kotlinx.coroutines.launch

internal class LoginFragmentViewModel(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    val onLogin = ActionLiveData<Unit>()

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val usernameHasError = MutableLiveData<Boolean>()
    val passwordHasError = MutableLiveData<Boolean>()

    fun onLogInClick() {
        val login = username.value.orEmpty()
        val password = password.value.orEmpty()

        viewModelScope.launch {
            isProgressVisible.withProgress {
                authRepository.login(login, password)
                    .doOnSuccess { onShowMessage.value = it.name }
                    .doOnError { onShowError.value = it }
            }
        }
    }
}