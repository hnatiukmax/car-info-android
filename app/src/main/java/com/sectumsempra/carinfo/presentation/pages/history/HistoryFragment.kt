package com.sectumsempra.carinfo.presentation.pages.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentHistoryBinding
import org.jetbrains.anko.AnkoContext

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return HistoryFragmentUi().createView(AnkoContext.create(requireContext(), this))
    }
}