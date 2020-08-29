package com.sectumsempra.carinfo.presentation.pages.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sectumsempra.carinfo.domain.core.AppException
import com.sectumsempra.carinfo.presentation.common.ActionLiveData

internal open class BaseViewModel : ViewModel() {

    /**
     * Base live variables, that are available for observing in [BaseActivity] or [BaseFragment].
     */
    val isProgressVisible = MutableLiveData<Boolean>()
    val onShowError = MutableLiveData<AppException>()
    val onShowMessage = MutableLiveData<Any>()
    val onCloseKeyboard = ActionLiveData<Unit>()
    val onClosePage = ActionLiveData<Unit>()

    fun onClosePageClick() {
        onClosePage.call()
    }
}