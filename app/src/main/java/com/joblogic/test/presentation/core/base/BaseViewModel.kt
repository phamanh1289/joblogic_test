package com.joblogic.test.presentation.core.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.joblogic.test.presentation.helper.enum.ErrorType
import com.joblogic.test.presentation.model.ErrorModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


open class BaseViewModel : ViewModel() {

    private val _onLoading = MutableStateFlow(false)
    val onLoading = _onLoading.asStateFlow()

    private val _onError = MutableStateFlow(ErrorModel())
    val onError = _onError.asStateFlow()

    fun show() {
        _onLoading.value = true
    }

    fun dismissLoading() {
        _onLoading.value = false
    }

    private fun setError(exception: String?, errorType: ErrorType = ErrorType.OTHER) {
        _onError.value = ErrorModel(
            message = exception ?: "",
            errorType = errorType
        )
    }

    fun getError(e: Throwable?) {
        dismissLoading()
        e?.let { setError(e.message) }
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
    }
}