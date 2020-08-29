package com.sectumsempra.carinfo.presentation.common

import androidx.lifecycle.MutableLiveData

internal inline fun MutableLiveData<Boolean>?.withProgress(block: () -> Unit) {
    if (this?.value != true) {
        this?.value = true
    }
    block.invoke()
    this?.value = false
}