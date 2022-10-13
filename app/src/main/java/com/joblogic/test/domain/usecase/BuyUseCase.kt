package com.joblogic.test.domain.usecase

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.repo.MainRepo

class BuyUseCase(private val mainRepo: MainRepo) {
    fun getItemBuy(
        onSuccess: (List<ItemResponse>) -> Unit, onError: (Throwable?) -> Unit
    ) = mainRepo.getItemBuy(onSuccess, onError)
}