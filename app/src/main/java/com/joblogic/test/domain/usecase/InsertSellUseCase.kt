package com.joblogic.test.domain.usecase

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.repo.MainRepo

class InsertSellUseCase(private val mainRepo: MainRepo) {
    fun insertItemCall(
        listData: List<ItemResponse>, onError: (Throwable?) -> Unit
    ) = mainRepo.insertItemSell(listData, onError)
}