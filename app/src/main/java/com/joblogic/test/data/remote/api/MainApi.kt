package com.joblogic.test.data.remote.api

import com.joblogic.test.domain.model.response.ItemResponse
import com.joblogic.test.domain.model.response.UserResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET


interface MainApi {

    @GET("imkhan334/demo-1/call")
    fun getCallAsync(): Deferred<Response<List<UserResponse>>>

    @GET("imkhan334/demo-1/buy")
    fun getBuyAsync(): Deferred<Response<List<ItemResponse>>>
}