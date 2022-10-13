package com.joblogic.test.data.extension

import kotlinx.coroutines.*
import retrofit2.Response

fun <T> CoroutineScope.asyncDataRemote(
    apiDeferred: Deferred<Response<T>>,
    onSuccess: (T) -> Unit,
    onError: (Throwable?) -> Unit
) {
    launch(Dispatchers.Main) {
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
    query: suspend CoroutineScope.(Int) -> Unit,
    onError: (Throwable?) -> Unit
): Job {

    return launch {
        try {
            query(1)
        } catch (e: Exception) {
            onError(e)
        }
    }
}
