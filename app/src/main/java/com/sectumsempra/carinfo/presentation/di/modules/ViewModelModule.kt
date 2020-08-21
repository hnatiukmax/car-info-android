package com.sectumsempra.carinfo.presentation.di.modules

import com.sectumsempra.carinfo.presentation.pages.history.HistoryFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModel { HistoryFragmentViewModel() }
}