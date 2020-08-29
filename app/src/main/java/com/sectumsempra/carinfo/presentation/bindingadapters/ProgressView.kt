package com.sectumsempra.carinfo.presentation.bindingadapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.sectumsempra.carinfo.presentation.extensions.gone
import com.sectumsempra.carinfo.presentation.extensions.visible
import me.zhanghai.android.materialprogressbar.MaterialProgressBar

@BindingAdapter("showProgress")
internal fun showProgress(view: MaterialProgressBar, isVisible: Boolean) {
    if (view.visibility != View.VISIBLE && isVisible) {
        view.visible()
    } else {
        view.gone()
    }
}