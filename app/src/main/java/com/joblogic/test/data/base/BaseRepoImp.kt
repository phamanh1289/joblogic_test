package com.joblogic.test.data.base

import com.joblogic.test.data.extension.asyncDataRemote
import com.joblogic.test.data.extension.asyncDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Response

open class BaseRepoImp {

    fun asyncDatabase(
        query: suspend CoroutineScope.() -> Unit,
        onError: (Throwable?) -> Unit
    ): Job {
        return CoroutineScope(Dispatchers.IO).asyncDatabase(
            query,
            onError = { onError(it) }
        )
    }

    fun <T> asyncDataRemote(
        apiDeferred: Deferred<Response<T>>,
        onSuccess: (T) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).asyncDataRemote(
            apiDeferred,
            onSuccess = { onSuccess(it) },
            onError = { onError(it) },
        )
    }
}