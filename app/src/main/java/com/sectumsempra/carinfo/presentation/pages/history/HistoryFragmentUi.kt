package com.sectumsempra.carinfo.presentation.pages.history

import android.view.Gravity
import androidx.fragment.app.Fragment
import org.jetbrains.anko.*

class HistoryFragmentUi : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        frameLayout {
            lparams(matchParent, matchParent)
            textView("History") {
                gravity = Gravity.CENTER
            }
        }
    }
}