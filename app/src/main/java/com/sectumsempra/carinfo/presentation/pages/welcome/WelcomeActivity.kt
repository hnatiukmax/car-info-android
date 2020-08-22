package com.sectumsempra.carinfo.presentation.pages.welcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sectumsempra.carinfo.R
import org.jetbrains.anko.setContentView

internal class WelcomeActivity : AppCompatActivity() {

    private lateinit var ui: WelcomeActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        ui = WelcomeActivityUI()
        ui.setContentView(this)
    }
}