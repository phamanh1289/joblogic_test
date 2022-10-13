package com.joblogic.test.presentation.feature.home.action

import android.os.Bundle
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.FragmentActionBinding
import com.joblogic.test.presentation.core.base.BaseFragment
import com.joblogic.test.presentation.feature.home.action.buy.BuyFragment
import com.joblogic.test.presentation.feature.home.action.call.CallFragment
import com.joblogic.test.presentation.feature.home.action.sell.SellFragment
import com.joblogic.test.presentation.helper.extension.addFragment
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActionFragment : BaseFragment<FragmentActionBinding, ActionViewModel>() {

    companion object {
        const val ACTION_CALL = 1
        const val ACTION_BUY = 2
        const val ACTION_SELL = 3
    }

    override val viewModel by viewModel<ActionViewModel>()

    override fun requestLayout() = R.layout.fragment_action

    override fun requestLayoutXml() = BR.frgAction

    override fun afterBinding(savedInstanceState: Bundle?) {
    }

    override fun observeViewModel(coroutineScope: CoroutineScope) {
    }

    fun onClickAction(action: Int) {
        val fragment =
            when (action) {
                ACTION_CALL -> CallFragment()
                ACTION_BUY -> BuyFragment()
                else -> SellFragment()
            }
        addFragment(fragment, isAddToBackStack = true)
    }
}