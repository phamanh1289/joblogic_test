package com.joblogic.test.presentation.feature.home.action.sell

import android.os.Bundle
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.FragmentSellBinding
import com.joblogic.test.presentation.core.base.BaseFragment
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class SellFragment : BaseFragment<FragmentSellBinding, SellViewModel>() {
    override val viewModel by viewModel<SellViewModel>()

    override fun requestLayout() = R.layout.fragment_sell

    override fun requestLayoutXml() = BR.frgSell

    override fun afterBinding(savedInstanceState: Bundle?) {
        updateTitle(getString(R.string.sell_list))
    }

    override fun observeViewModel(coroutineScope: CoroutineScope) {
    }
}