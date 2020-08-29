package com.sectumsempra.carinfo.presentation.pages.authentication.register

import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentRegisterBinding
import com.sectumsempra.carinfo.presentation.pages.authentication.AuthFragmentType
import com.sectumsempra.carinfo.presentation.pages.authentication.OnAuthTypeChangeListener
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment

internal class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel>() {

    override val layoutRes = R.layout.fragment_register
    override val viewModelClass = RegisterFragmentViewModel::class

    companion object {
        fun newInstance() = RegisterFragment()
    }

    override fun FragmentRegisterBinding.initUI() {
        viewModel = this@RegisterFragment.viewModel

        haveAnAccount.setOnClickListener {
            (activity as? OnAuthTypeChangeListener)?.onAuthTypeChange(AuthFragmentType.LOGIN)
        }
    }
}