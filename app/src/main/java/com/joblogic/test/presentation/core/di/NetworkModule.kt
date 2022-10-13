package com.joblogic.test.presentation.core.di

import com.joblogic.test.data.remote.provider.Providers
import com.joblogic.test.data.remote.retofit.MainRetrofit
import org.koin.dsl.module

val networkModule = module {
    single { MainRetrofit(get()) }
    single { Providers.mainProvider(get()) }
}