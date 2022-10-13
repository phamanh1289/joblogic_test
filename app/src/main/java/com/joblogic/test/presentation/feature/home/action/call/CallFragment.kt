package com.joblogic.test.presentation.feature.home.action.call

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.FragmentCallBinding
import com.joblogic.test.presentation.core.base.BaseFragment
import com.joblogic.test.presentation.helper.extension.showToast
import com.joblogic.test.presentation.other.adapter.CallAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CallFragment : BaseFragment<FragmentCallBinding, CallViewModel>() {

    private val callAdapter = CallAdapter {
        handleOnClickItem(it)
    }

    override val viewModel by viewModel<CallViewModel>()

    override fun requestLayout() = R.layout.fragment_call

    override fun requestLayoutXml() = BR.frgCall

    override fun afterBinding(savedInstanceState: Bundle?) {
        initRcvItem()
        updateTitle(getString(R.string.call_list))
    }

    override fun observeViewModel(coroutineScope: CoroutineScope) {
        coroutineScope.run {
            launch {
                viewModel.listItem.collect {
                    callAdapter.submitList(it)
                }
            }
        }
    }

    private fun initRcvItem() {
        binding.frgCallRcvItem.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = callAdapter
            setHasFixedSize(true)
        }
    }

    private fun handleOnClickItem(index: Int) {
        showToast(callAdapter.currentList[index].toString())
    }
}