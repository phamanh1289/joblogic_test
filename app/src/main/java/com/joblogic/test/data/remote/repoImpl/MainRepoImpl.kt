package com.joblogic.test.data.remote.repoImpl

import com.joblogic.test.data.base.BaseRepoImp
import com.joblogic.test.data.remote.api.MainApi
import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.model.response.UserResponse
import com.joblogic.test.domain.repo.MainRepo

class MainRepoImpl(
    private val mainApi: MainApi,
) : BaseRepoImp(), MainRepo {
    override fun getItemCall(
        onSuccess: (List<UserResponse>) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        asyncDataRemote(
            mainApi.getCallAsync(),
            onSuccess = { onSuccess(it) },
            onError = onError
        )
    }

    override fun getItemBuy(
        onSuccess: (List<ItemResponse>) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        asyncDataRemote(
            mainApi.getBuyAsync(),
            onSuccess = { onSuccess(it) },
            onError = onError
        )
    }

}