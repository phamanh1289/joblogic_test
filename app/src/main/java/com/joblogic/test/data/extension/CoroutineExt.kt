package com.joblogic.test.data.extension

import kotlinx.coroutines.*
import retrofit2.Response

fun <T> CoroutineScope.asyncDataRemote(
    apiDeferred: Deferred<Response<T>>,
    onSuccess: (T) -> Unit,
    onError: (Throwable?) -> Unit
) {
    launch {
        try {
            apiDeferred.await().run {
                when {
                    isSuccessful -> body()?.let { onSuccess(it) }
                    else ->
                        onError(
                            Throwable(
                                "${code()} - ${
                                    if (errorBody() != null) errorBody()?.string() else message()
                                }"
                            )
                        )
                }
            }
        } catch (e: Exception) {
            onError(e)
        }
    }
}

fun CoroutineScope.asyncDatabase(
    query: suspend CoroutineScope.() -> Unit,
    onError: (Throwable?) -> Unit
): Job {
    return launch {
        try {
            query()
        } catch (e: Exception) {
            onError(e)
        }
    }
}
