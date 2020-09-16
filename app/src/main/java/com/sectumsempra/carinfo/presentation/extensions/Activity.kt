package com.sectumsempra.carinfo.presentation.extensions

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.presentation.enum.AnimationType

internal fun FragmentActivity.hideSoftKeyboard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

internal fun FragmentTransaction.setTransition(animationType: AnimationType) {
    val (animIn, animOut) = when (animationType) {
        AnimationType.SLIDE_LEFT -> R.anim.slide_left_enter to R.anim.slide_left_exit
        AnimationType.SLIDE_RIGHT -> R.anim.slide_in_left to R.anim.slide_out_right
    }

    setCustomAnimations(animIn, animOut)
}

internal fun AppCompatActivity.setFullScreen() {
    window.apply {
        clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}