package com.joblogic.test.presentation.feature.home

import com.joblogic.test.presentation.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class BackStackViewModel : BaseViewModel() {
    private val _countBack = MutableStateFlow(0)
    val countBack: StateFlow<Int>
        get() = _countBack

    fun clearCountBack() {
        _countBack.value = 0
    }

    fun addCountBack() {
        _countBack.update { it.inc() }
    }

    fun subCountBack() {
        _countBack.update { it.dec() }
    }
}
