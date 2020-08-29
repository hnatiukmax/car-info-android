package com.sectumsempra.carinfo.presentation.pages.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.sectumsempra.carinfo.domain.core.StringResource
import com.sectumsempra.carinfo.presentation.extensions.hideSoftKeyboard
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

internal abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private val baseActivity get() = (activity as? BaseActivity<*, *>)

    protected abstract val layoutRes: Int
    protected abstract val viewModelClass: KClass<VM>

    protected lateinit var binding: V

    protected val viewModel by lazy { getViewModel(viewModelClass) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(DataBindingUtil.inflate<V>(layoutInflater, layoutRes, container, false)) {
        binding = this
        lifecycleOwner = this@BaseFragment.viewLifecycleOwner
        initUI()
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.apply {
            onShowMessage.observe {
                when (this) {
                    is String -> toast(this)
                    is StringResource -> toast(messageResId)
                }
            }
            onShowError.observe { toast(message ?: "") }
            onCloseKeyboard.observe { baseActivity?.hideSoftKeyboard() }
            observeViewModel()
        }
    }

    protected open fun VM.observeViewModel() {
        /* Default implementation */
    }

    protected open fun V.initUI() {
        /* Default implementation */
    }

    protected inline fun <P> LiveData<P>.observe(crossinline observerBody: (P.() -> Unit)) {
        observe(viewLifecycleOwner) {
            observerBody(it)
        }
    }
}