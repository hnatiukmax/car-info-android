package com.sectumsempra.carinfo.presentation.pages.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.presentation.pages.numberscanner.NumberScannerActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.toast

class SearchFragment : Fragment() {

    private lateinit var ui: SearchFragmentUI

    private val getNumber = registerForActivityResult(NumberScannerActivity.GetNumber()) { number: String? ->
        toast(number ?: "empty")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(SearchFragmentUI()) {
        ui = this
        ui.createView(AnkoContext.create(requireContext(), this@SearchFragment)).apply {
            initUI()
        }
    }

    private fun SearchFragmentUI.initUI() {
        scannerSearchCard.setOnClickListener {
            getNumber.launch()
        }
    }
}