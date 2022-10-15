package com.joblogic.test.presentation.feature.home.action.buy

import android.os.Bundle
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.FragmentBuyBinding
import com.joblogic.test.presentation.core.base.BaseFragment
import com.joblogic.test.presentation.helper.extension.initAdapter
import com.joblogic.test.presentation.helper.extension.showToast
import com.joblogic.test.presentation.other.adapter.BuyAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BuyFragment : BaseFragment<FragmentBuyBinding, BuyViewModel>() {

    private val buyAdapter = BuyAdapter {
        handleOnClickItem(it)
    }

    override val viewModel by viewModel<BuyViewModel>()

    override fun requestLayout() = R.layout.fragment_buy

    override fun requestLayoutXml() = BR.frgBuy

    override fun afterBinding(savedInstanceState: Bundle?) {
        updateTitle(getString(R.string.buy_list))
        initRcvItem()
    }

    override fun observeViewModel(coroutineScope: CoroutineScope) {
        coroutineScope.run {
            launch {
                viewModel.listItem.collect {
                    buyAdapter.submitList(it)
                }
            }
        }
    }

    private fun initRcvItem() {
        binding.frgBuyRcvItem.initAdapter(buyAdapter)
    }

    private fun handleOnClickItem(index: Int) {
        showToast(buyAdapter.currentList[index].toString())
    }
}