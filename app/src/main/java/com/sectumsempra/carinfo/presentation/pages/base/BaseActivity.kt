package com.sectumsempra.carinfo.presentation.pages.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.sectumsempra.carinfo.domain.core.StringResource
import com.sectumsempra.carinfo.presentation.extensions.hideSoftKeyboard
import org.jetbrains.anko.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

internal abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected abstract val layoutRes: Int
    protected abstract val viewModelClass: KClass<VM>

    protected lateinit var binding: V
    protected val viewModel by lazy { getViewModel(viewModelClass) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.apply {
            lifecycleOwner = this@BaseActivity
            initUI()
        }

        viewModel.apply {
            onShowMessage.observe(this@BaseActivity) {
                when (it) {
                    is String -> toast(it)
                    is StringResource -> toast(it.messageResId)
                }
            }
            onShowError.observe(this@BaseActivity) { toast(it.message ?: "") }
            onCloseKeyboard.observe(this@BaseActivity) { hideSoftKeyboard() }
            onClosePage.observe { onBackPressed() }
            observeViewModel()
        }
    }

    protected open fun VM.observeViewModel() {}

    protected open fun V.initUI() {}

    protected inline fun <P> LiveData<P>.observe(crossinline observerBody: (P.() -> Unit)) {
        this.observe(this@BaseActivity) {
            observerBody(it)
        }
    }
}