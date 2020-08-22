package com.sectumsempra.carinfo.presentation.pages.welcome

import android.view.Gravity
import org.jetbrains.anko.*

internal class WelcomeActivityUI : AnkoComponent<WelcomeActivity> {

    override fun createView(ui: AnkoContext<WelcomeActivity>) = with(ui) {
        frameLayout {
            lparams(matchParent, matchParent)
            textView("Welcome") {
                gravity = Gravity.CENTER
            }
        }
    }
}