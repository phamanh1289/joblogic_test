package com.joblogic.test.presentation.feature.home.action.buy

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.usecase.BuyUseCase
import com.joblogic.test.domain.usecase.InsertSellUseCase
import com.joblogic.test.presentation.core.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class BuyViewModel(
    private val buyUseCase: BuyUseCase, private val insertSellUseCase: InsertSellUseCase
) : BaseViewModel() {

    private val _listItem = MutableSharedFlow<List<ItemResponse>>(replay = 1)
    val listItem = _listItem.asSharedFlow()

    init {
        getBuyList()
    }

    private fun getBuyList() {
        show()
        buyUseCase.getItemBuy(onSuccess = {
            _listItem.tryEmit(it)
            insertSell(it)
            dismissLoading()
        }, onError = {
            getError(it)
        })
    }

    private fun insertSell(listItem: List<ItemResponse>) {
        insertSellUseCase.insertItemCall(listItem, onError = {
            getError(it)
        })
    }
}