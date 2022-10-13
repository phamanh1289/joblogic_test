package com.joblogic.test.data.remote.retofit

import android.app.Application
import com.joblogic.test.data.base.BaseRetrofit
import com.joblogic.test.data.other.constant.DataConstants
import okhttp3.Interceptor
import okhttp3.Response


class MainRetrofit(
    application: Application
) : BaseRetrofit(application) {

    init {
        addInterceptors(HeaderInterceptor())
    }

    override fun requestBaseUrl() = DataConstants.BASE_URL

    inner class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            return chain.proceed(chain.request().newBuilder().build())
        }
    }

}