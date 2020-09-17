package com.sectumsempra.carinfo.presentation.extensions

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.domain.core.StringResource
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

internal fun AppCompatActivity.makeToolbarAsActionBar(toolbar: Toolbar) {
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(false)
}

internal fun AppCompatActivity.setToolbarTitle(title: String) {
    supportActionBar?.title = title
}

internal fun AppCompatActivity.setToolbarTitle(title: StringResource?) {
    supportActionBar?.title = getString(title?.messageResId ?: return)
}

internal fun AppCompatActivity.enableBackButton(@DrawableRes icon: Int = R.drawable.ic_back_black) = supportActionBar?.let {
    it.setDisplayHomeAsUpEnabled(true)
    it.setDisplayShowHomeEnabled(true)
    it.setHomeAsUpIndicator(icon)
}