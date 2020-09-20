package com.sectumsempra.carinfo.presentation.pages.carinfo

import android.content.Context
import android.content.Intent
import com.sectumsempra.carinfo.R
import com.sectumsempra.carinfo.databinding.ActivityCarInfoBinding
import com.sectumsempra.carinfo.presentation.extensions.stringExtraOrException
import com.sectumsempra.carinfo.presentation.pages.base.BaseToolbarActivity
import com.sectumsempra.carinfo.presentation.pages.base.Depends
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

@Depends(R.layout.activity_car_info, CarInfoActivityViewModel::class)
internal class CarInfoActivity : BaseToolbarActivity<ActivityCarInfoBinding, CarInfoActivityViewModel>() {

    val number by lazy { stringExtraOrException(ARG_NUMBER) }

    override val viewModel by viewModel<CarInfoActivityViewModel> { parametersOf(number) }

    companion object {
        private const val ARG_NUMBER = "ARG_NUMBER"

        fun getIntent(context: Context, number: String) = Intent(context, CarInfoActivity::class.java).apply {
            putExtra(ARG_NUMBER, number)
        }
    }

    override fun ActivityCarInfoBinding.initUI() {
        viewModel = this@CarInfoActivity.viewModel
    }
}