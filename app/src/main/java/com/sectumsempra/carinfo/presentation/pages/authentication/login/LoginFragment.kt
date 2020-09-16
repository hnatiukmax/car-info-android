package com.sectumsempra.carinfo.presentation.pages.authentication.login

import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentLoginBinding
import com.sectumsempra.carinfo.presentation.pages.authentication.AuthFragmentType
import com.sectumsempra.carinfo.presentation.pages.authentication.OnAuthTypeChangeListener
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import com.sectumsempra.carinfo.presentation.pages.base.Depends

@Depends(R.layout.fragment_login, LoginFragmentViewModel::class)
internal class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {

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