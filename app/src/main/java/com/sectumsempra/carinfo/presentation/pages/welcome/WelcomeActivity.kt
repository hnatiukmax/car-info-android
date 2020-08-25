package com.sectumsempra.carinfo.presentation.pages.welcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.ActivityWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class WelcomeActivity : AppCompatActivity() {

    private val viewModel: WelcomeActivityViewModel by viewModel()
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        binding.apply {
            lifecycleOwner = this@WelcomeActivity
            viewModel = this@WelcomeActivity.viewModel
        }
    }
}