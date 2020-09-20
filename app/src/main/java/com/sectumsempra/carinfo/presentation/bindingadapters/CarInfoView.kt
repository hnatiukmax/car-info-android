package com.sectumsempra.carinfo.presentation.bindingadapters

import androidx.databinding.BindingAdapter
import com.sectumsempra.carinfo.presentation.view.CarInfoParamView

@BindingAdapter("value")
internal fun setValue(view: CarInfoParamView, value: String?) {
    if (value != view.value) {
        view.value = value ?: ""
    }
}