package com.joblogic.test.domain.repo

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.model.response.UserResponse

interface MainRepo {

    fun getItemCall(
        onSuccess: (List<UserResponse>) -> Unit, onError: (Throwable?) -> Unit
    )

    fun getItemBuy(
        onSuccess: (List<ItemResponse>) -> Unit, onError: (Throwable?) -> Unit
    )

    fun insertItemSell(listItem: List<ItemResponse>, onError: (Throwable?) -> Unit)

    fun getItemSell(
        onSuccess: (List<ItemResponse>) -> Unit, onError: (Throwable?) -> Unit
    )
}