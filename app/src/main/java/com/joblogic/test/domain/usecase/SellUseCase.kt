package com.joblogic.test.domain.usecase

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.repo.MainRepo

class SellUseCase(private val mainRepo: MainRepo) {
    fun getItemCall(
        onSuccess: (List<ItemResponse>) -> Unit, onError: (Throwable?) -> Unit
    ) = mainRepo.getItemSell(onSuccess, onError)
}