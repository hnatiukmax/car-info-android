package com.sectumsempra.carinfo.presentation.pages.authentication

import androidx.fragment.app.commit
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.ActivityAuthBinding
import com.sectumsempra.carinfo.presentation.enum.AnimationType
import com.sectumsempra.carinfo.presentation.extensions.setTransition
import com.sectumsempra.carinfo.presentation.pages.authentication.login.LoginFragment
import com.sectumsempra.carinfo.presentation.pages.authentication.register.RegisterFragment
import com.sectumsempra.carinfo.presentation.pages.base.BaseActivity
import com.sectumsempra.carinfo.presentation.pages.base.Depends

@Depends(R.layout.activity_auth, AuthViewModel::class)
internal class AuthActivity : BaseActivity<ActivityAuthBinding, AuthViewModel>(), OnAuthTypeChangeListener {

    override fun ActivityAuthBinding.initUI() {
        viewModel = this@AuthActivity.viewModel
        onAuthTypeChange(AuthFragmentType.LOGIN)
    }

    override fun onAuthTypeChange(authFragmentType: AuthFragmentType) {
        val (fragment, anim) = when (authFragmentType) {
            AuthFragmentType.LOGIN -> LoginFragment.newInstance() to AnimationType.SLIDE_RIGHT
            AuthFragmentType.REGISTER -> RegisterFragment.newInstance() to AnimationType.SLIDE_LEFT
        }

        supportFragmentManager.commit {
            if (supportFragmentManager.fragments.isNotEmpty()) {
                setTransition(anim)
            }
            replace(R.id.fragment_container, fragment)
        }
    }
}