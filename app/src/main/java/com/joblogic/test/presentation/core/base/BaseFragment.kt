package com.joblogic.test.presentation.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.joblogic.test.presentation.feature.home.MainActivity
import com.joblogic.test.presentation.helper.extension.hideLoading
import com.joblogic.test.presentation.helper.extension.showLoading
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    lateinit var binding: VDB

    protected abstract val viewModel: VM?

    @LayoutRes
    abstract fun requestLayout(): Int

    abstract fun requestLayoutXml(): Int?

    abstract fun afterBinding(savedInstanceState: Bundle?)

    abstract fun observeViewModel(coroutineScope: CoroutineScope)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, requestLayout(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            requestLayoutXml()?.run { setVariable(this, this@BaseFragment) }
            executePendingBindings()
        }
        afterBinding(savedInstanceState)
        initLoading()
    }

    private fun initLoading() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                observeViewModel(this)
                viewModel?.run {
                    launch {
                        onLoading.collect {
                            when (it) {
                                true -> this@BaseFragment.showLoading()
                                else -> this@BaseFragment.hideLoading()
                            }
                        }
                    }
                    launch {
                        onError.collect {
                            if (it.message.isNotEmpty())
                                showAlter(content = it.message)
                        }
                    }
                }
            }
        }
    }

    private fun showAlter(
        content: String? = null
    ) {
        Toast.makeText(requireActivity(), content.toString(), Toast.LENGTH_SHORT).show()
    }


    fun setResult(key: String, bundle: Bundle) {
        parentFragmentManager.setFragmentResult(key, bundle)
    }

    fun setResultCallBack(key: String, onData: (Bundle) -> Unit) {
        parentFragmentManager.setFragmentResultListener(key, this) { _, bundle ->
            onData(bundle)
        }
    }

    fun updateTitle(title: String?) {
        activity?.let {
            if (it is MainActivity)
                it.updateTitle(title)
        }
    }

}