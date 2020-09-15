package com.sectumsempra.carinfo.presentation.pages.search

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sectumsempra.carinfo.R
import org.jetbrains.anko.AnkoContext

class SearchFragment : Fragment() {

    private lateinit var ui: SearchFragmentUI

    val getNumber = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

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
            findNavController().navigate(R.id.toNumberScannerFragment)


        }
    }

    inner class NumberActivityContract : ActivityResultContract<Unit, String>() {
        override fun createIntent(context: Context, input: Unit?): Intent {
            return Intent()
        }

        override fun parseResult(resultCode: Int, intent: Intent?): String {
            TODO("Not yet implemented")
        }
    }
}