package com.joblogic.test.presentation.feature.home

import android.os.Bundle
import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.ActivityMainBinding
import com.joblogic.test.presentation.core.base.BaseActivity
import com.joblogic.test.presentation.feature.home.action.ActionFragment
import com.joblogic.test.presentation.helper.extension.addFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val _titleHeader = MutableStateFlow("")
    val titleHeader = _titleHeader.asStateFlow()

    private val stackViewModel by viewModel<BackStackViewModel>()

    override val viewModel by viewModel<MainViewModel>()

    override fun requestLayoutId() = R.layout.activity_main

    override fun requestLayoutXml() = BR.actMain

    override fun afterBinding(savedInstanceState: Bundle?) {
        addFragment(ActionFragment(), isAddToBackStack = false)
    }

    override fun observeViewModel() {}

    fun getCountBack() = stackViewModel.countBack

    fun addCountBack() = stackViewModel.addCountBack()

    override fun onBackPressed() {
        stackViewModel.run {
            subCountBack()
            if (countBack.value == 0)
                updateTitle(null)
            super.onBackPressed()
        }
    }

    fun updateTitle(title: String?) {
        _titleHeader.value = title ?: ""
    }
}