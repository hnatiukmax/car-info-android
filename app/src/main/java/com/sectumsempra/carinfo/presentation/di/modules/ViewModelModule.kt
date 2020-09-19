package com.sectumsempra.carinfo.presentation.di.modules

import com.sectumsempra.carinfo.presentation.pages.authentication.AuthViewModel
import com.sectumsempra.carinfo.presentation.pages.authentication.login.LoginFragmentViewModel
import com.sectumsempra.carinfo.presentation.pages.authentication.register.RegisterFragmentViewModel
import com.sectumsempra.carinfo.presentation.pages.bookmarks.BookMarksFragmentViewModel
import com.sectumsempra.carinfo.presentation.pages.history.HistoryFragmentViewModel
import com.sectumsempra.carinfo.presentation.pages.numberscanner.NumberScannerActivityViewModel
import com.sectumsempra.carinfo.presentation.pages.search.SearchFragmentViewModel
import com.sectumsempra.carinfo.presentation.pages.welcome.WelcomeActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModel { HistoryFragmentViewModel() }
    viewModel { WelcomeActivityViewModel() }
    viewModel { AuthViewModel() }
    viewModel { LoginFragmentViewModel(get()) }
    viewModel { RegisterFragmentViewModel(get()) }
    viewModel { BookMarksFragmentViewModel() }
    viewModel { NumberScannerActivityViewModel() }
    viewModel { SearchFragmentViewModel() }
}