package com.sectumsempra.carinfo.presentation.pages.bookmarks

import android.annotation.SuppressLint
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.FragmentBookmarksBinding
import com.sectumsempra.carinfo.presentation.pages.base.BaseFragment
import com.sectumsempra.carinfo.presentation.pages.base.Depends

@SuppressLint("NonConstantResourceId")
@Depends(R.layout.fragment_bookmarks, BookMarksFragmentViewModel::class)
internal class BookMarksFragment : BaseFragment<FragmentBookmarksBinding, BookMarksFragmentViewModel>()