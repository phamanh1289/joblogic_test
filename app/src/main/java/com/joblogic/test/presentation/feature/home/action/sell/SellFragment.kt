package com.joblogic.test.presentation.feature.home.action.sell

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.FragmentSellBinding
import com.joblogic.test.presentation.core.base.BaseFragment
import com.joblogic.test.presentation.helper.extension.showToast
import com.joblogic.test.presentation.other.adapter.BuyAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SellFragment : BaseFragment<FragmentSellBinding, SellViewModel>() {

    private val sellAdapter = BuyAdapter {
        handleOnClickItem(it)
    }

    override val viewModel by viewModel<SellViewModel>()

    override fun requestLayout() = R.layout.fragment_sell

    override fun requestLayoutXml() = BR.frgSell

    override fun afterBinding(savedInstanceState: Bundle?) {
        updateTitle(getString(R.string.sell_list))
        initRcvItem()
    }

    override fun observeViewModel(coroutineScope: CoroutineScope) {
        coroutineScope.run {
            launch {
                viewModel.listItem.collect {
                    sellAdapter.submitList(it)
                    binding.isEmpty = it.isEmpty()
                }
            }
        }
    }

    private fun initRcvItem() {
        binding.frgSellRcvItem.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = sellAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleOnClickItem(index: Int) {
        showToast(sellAdapter.currentList[index].toString())
    }
}