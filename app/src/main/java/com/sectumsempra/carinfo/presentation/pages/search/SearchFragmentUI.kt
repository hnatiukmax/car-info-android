package com.sectumsempra.carinfo.presentation.pages.search

import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.presentation.utils.OverScrollBehavior
import com.sectumsempra.carinfo.presentation.view.component.searchCard
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.support.v4.nestedScrollView

class SearchFragmentUI : AnkoComponent<Fragment> {

    lateinit var scannerSearchCard: RelativeLayout
    lateinit var typingSearchCard: RelativeLayout

    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        coordinatorLayout {
            lparams(matchParent, matchParent)
            nestedScrollView {
                scrollView {
                    linearLayout {
                        orientation = LinearLayout.VERTICAL

                        textView(R.string.bottom_navigation_search) {
                            textSize = 26f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams {
                            gravity = Gravity.START
                            setMargins(dip(16), dip(24), dip(16), dip(8))
                        }

                        scannerSearchCard = searchCard(
                            logoRes = R.drawable.logo_scanning,
                            iconRes = R.drawable.ic_camera,
                            backgroundIconRes = R.drawable.background_scanning_icon,
                            titleRes = R.string.search_card_scanning_title,
                            descriptionRes = R.string.search_card_scanning_description
                        )

                        typingSearchCard = searchCard(
                            logoRes = R.drawable.logo_typing,
                            iconRes = R.drawable.ic_typing,
                            backgroundIconRes = R.drawable.background_typing_icon,
                            titleRes = R.string.search_card_typing_title,
                            descriptionRes = R.string.search_card_typing_description
                        )
                    }.lparams(matchParent, matchParent)
                }.lparams(matchParent, matchParent)
            }.lparams(matchParent, matchParent) {
                behavior = OverScrollBehavior()
                overScrollMode = CoordinatorLayout.OVER_SCROLL_NEVER
            }
        }
    }
}