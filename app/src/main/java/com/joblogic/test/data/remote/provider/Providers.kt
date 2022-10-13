package com.joblogic.test.data.remote.provider

import com.joblogic.test.data.remote.api.MainApi
import com.joblogic.test.data.remote.retofit.MainRetrofit

class Providers {
    companion object {
        fun mainProvider(otherProvider: MainRetrofit): MainApi {
            return otherProvider.retrofit.create(MainApi::class.java)
        }
    }
}