package com.sectumsempra.carinfo.presentation.pages.authentication.login

import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentLoginBinding
import com.sectumsempra.carinfo.presentation.pages.authentication.AuthFragmentType
import com.sectumsempra.carinfo.presentation.pages.authentication.OnAuthTypeChangeListener
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment

internal class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {

    override val layoutRes = R.layout.fragment_login
    override val viewModelClass = LoginFragmentViewModel::class

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun FragmentLoginBinding.initUI() {
        viewModel = this@LoginFragment.viewModel

        noAccount.setOnClickListener {
            (activity as? OnAuthTypeChangeListener)?.onAuthTypeChange(AuthFragmentType.REGISTER)
        }
    }
}