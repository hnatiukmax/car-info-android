package com.sectumsempra.carinfo.presentation.extensions

import android.content.Intent

fun Intent?.intExtraOrNull(extraTag: String): Int? = if (this != null && hasExtra(extraTag)) getIntExtra(extraTag, 0) else null