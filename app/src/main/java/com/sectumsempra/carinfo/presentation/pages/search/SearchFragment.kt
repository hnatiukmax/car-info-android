package com.sectumsempra.carinfo.presentation.pages.search

import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentSearchBinding
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import com.sectumsempra.carinfo.presentation.pages.base.Depends

@Depends(R.layout.fragment_search, SearchFragmentViewModel::class)
internal class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentViewModel>() {

    override fun FragmentSearchBinding.initUI() {
        viewModel = this@SearchFragment.viewModel
    }
}