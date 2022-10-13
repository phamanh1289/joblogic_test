package com.joblogic.test.presentation.core.di

import com.joblogic.test.data.remote.repoImpl.MainRepoImpl
import com.joblogic.test.domain.repo.MainRepo
import com.joblogic.test.domain.usecase.BuyUseCase
import com.joblogic.test.domain.usecase.CallUseCase
import com.joblogic.test.domain.usecase.InsertSellUseCase
import com.joblogic.test.domain.usecase.SellUseCase
import org.koin.dsl.module

val useCaseModule = module{
    single { CallUseCase(get()) }
    single { BuyUseCase(get()) }
    single { SellUseCase(get()) }
    single { InsertSellUseCase(get()) }
}