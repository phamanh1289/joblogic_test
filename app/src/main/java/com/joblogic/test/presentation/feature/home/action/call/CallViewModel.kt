package com.joblogic.test.presentation.feature.home.action.call

import com.joblogic.test.domain.model.response.UserResponse
import com.joblogic.test.domain.usecase.CallUseCase
import com.joblogic.test.presentation.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class CallViewModel(private val callUseCase: CallUseCase) : BaseViewModel() {
    val _listItem = MutableSharedFlow<List<UserResponse>>(replay = 1)
    val listItem = _listItem.asSharedFlow()

    init {
        getCallList()
    }

   private fun getCallList() {
        show()
        callUseCase.getItemCall(onSuccess = {
            _listItem.tryEmit(it)
            dismissLoading()
        }, onError = {
            getError(it)
        })
    }
}