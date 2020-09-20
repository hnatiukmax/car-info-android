package com.sectumsempra.carinfo.presentation.pages.search

import android.os.Handler
import androidx.activity.result.launch
import androidx.core.os.postDelayed
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentSearchBinding
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import com.sectumsempra.carinfo.presentation.pages.base.Depends
import com.sectumsempra.carinfo.presentation.pages.carinfo.CarInfoActivity
import com.sectumsempra.carinfo.presentation.pages.numberscanner.NumberScannerActivity
import org.jetbrains.anko.support.v4.toast

@Depends(R.layout.fragment_search, SearchFragmentViewModel::class)
internal class SearchFragment : BaseFragment<FragmentSearchBinding, SearchFragmentViewModel>() {

    private val getNumber = registerForActivityResult(NumberScannerActivity.GetNumber()) {
        toast(it ?: "empty")
        Handler().postDelayed(1000L) {
            startActivity(CarInfoActivity.getIntent(requireContext(), it ?: ""))
        }
    }

    override fun FragmentSearchBinding.initUI() {
        viewModel = this@SearchFragment.viewModel
        scanningSearch.onSearchCardClickListener = {
            getNumber.launch()
        }
    }
}