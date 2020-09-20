package com.sectumsempra.carinfo.presentation.pages.carinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sectumsempra.carinfo.data.network.responses.CarInfoNT
import com.sectumsempra.carinfo.domain.extensions.doOnError
import com.sectumsempra.carinfo.domain.extensions.doOnSuccess
import com.sectumsempra.carinfo.domain.repository.CarInfoRepository
import com.sectumsempra.carinfo.presentation.common.withProgress
import com.sectumsempra.carinfo.presentation.pages.base.BaseViewModel
import kotlinx.coroutines.launch

internal class CarInfoActivityViewModel(
    private val number: String,
    private val carInfoRepository: CarInfoRepository
) : BaseViewModel() {

    val carInfo by lazy {
        MutableLiveData<CarInfoNT>().also {
            loadCarInfo()
        }
    }

    private fun loadCarInfo() {
        viewModelScope.launch {
            isProgressVisible.withProgress {
                carInfoRepository.getCarInfoByNumber(number)
                    .doOnSuccess { carInfo.value = it }
                    .doOnError { onShowError.value = it }
            }
        }
    }
}