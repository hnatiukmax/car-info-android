package com.sectumsempra.carinfo.presentation.pages.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.databinding.FragmentHistoryBinding
import org.jetbrains.anko.AnkoContext

class ExploreFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ExploreFragmentUI().createView(AnkoContext.create(requireContext(), this))
    }
}