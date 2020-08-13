package com.sectumsempra.carinfo.presentation.pages.history

import android.view.Gravity
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.presentation.view.component.searchCard
import org.jetbrains.anko.*

class HistoryFragmentUi : AnkoComponent<Fragment> {

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        verticalLayout {
            lparams(matchParent, matchParent)
            textView("History")
                .lparams {
                    gravity = Gravity.CENTER
                }
//            searchCard(
//                logoRes = R.drawable.logo_scanning,
//                iconRes = R.drawable.ic_camera,
//                titleRes = R.string.search_card_scanning_title,
//                descriptionRes = R.string.search_card_scanning_description
//            )
        }
    }
}