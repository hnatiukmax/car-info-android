package com.sectumsempra.carinfo.presentation.pages.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.databinding.FragmentSearchBinding
import org.jetbrains.anko.AnkoContext

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return SearchFragmentUI().createView(AnkoContext.create(requireContext(), this))
    }
}