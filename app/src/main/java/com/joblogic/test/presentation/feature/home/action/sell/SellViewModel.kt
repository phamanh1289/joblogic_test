package com.joblogic.test.presentation.feature.home.action.sell

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.usecase.SellUseCase
import com.joblogic.test.presentation.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SellViewModel(private val sellUseCase: SellUseCase) : BaseViewModel() {

    private val _listItem = MutableSharedFlow<List<ItemResponse>>(replay = 1)
    val listItem = _listItem.asSharedFlow()

    init {
        getSellItem()
    }

    private fun getSellItem() {
        sellUseCase.getItemCall(onSuccess = {
            _listItem.tryEmit(it)
            dismissLoading()
        }, onError = { getError(it) })
    }
}