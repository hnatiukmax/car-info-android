package com.sectumsempra.carinfo.presentation.pages.authentication.register

import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentRegisterBinding
import com.sectumsempra.carinfo.presentation.pages.authentication.AuthFragmentType
import com.sectumsempra.carinfo.presentation.pages.authentication.OnAuthTypeChangeListener
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import com.sectumsempra.carinfo.presentation.pages.base.Depends

@Depends(R.layout.fragment_register, RegisterFragmentViewModel::class)
internal class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterFragmentViewModel>() {

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