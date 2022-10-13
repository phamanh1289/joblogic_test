package com.joblogic.test.domain.usecase

import com.joblogic.test.domain.model.response.UserResponse
import com.joblogic.test.domain.repo.MainRepo

class CallUseCase(private val mainRepo: MainRepo) {
    fun getItemCall(
        onSuccess: (List<UserResponse>) -> Unit, onError: (Throwable?) -> Unit
    ) = mainRepo.getItemCall(onSuccess, onError)
}