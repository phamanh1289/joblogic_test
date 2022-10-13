package com.joblogic.test.presentation.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.joblogic.test.presentation.other.dialog.LoadingDialog


abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: VDB

    abstract val viewModel: VM?

    @LayoutRes
    abstract fun requestLayoutId(): Int

    abstract fun requestLayoutXml(): Int?

    abstract fun afterBinding(savedInstanceState: Bundle?)

    abstract fun observeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(requestLayoutId())
        initDataBinding()
        afterBinding(savedInstanceState)
        observeViewModel()
    }

    private fun initDataBinding() {
        if (!this::binding.isInitialized)
            binding = DataBindingUtil.setContentView(this, requestLayoutId())
        binding.run {
            lifecycleOwner = this@BaseActivity
            requestLayoutXml()?.run { setVariable(this, this@BaseActivity) }
        }
    }

    fun showLoading() {
        supportFragmentManager.let {
            if (!it.isStateSaved) {
                BaseApplication.instance.loadingDialog
                    .show(it, LoadingDialog::class.java.simpleName)
            }
        }
    }

    fun hideLoading() = BaseApplication.instance.loadingDialog.dismiss()

}