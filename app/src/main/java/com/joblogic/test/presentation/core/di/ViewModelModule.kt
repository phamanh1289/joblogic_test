package com.joblogic.test.presentation.core.di

import com.joblogic.test.presentation.feature.home.BackStackViewModel
import com.joblogic.test.presentation.feature.home.MainViewModel
import com.joblogic.test.presentation.feature.home.action.ActionViewModel
import com.joblogic.test.presentation.feature.home.action.buy.BuyViewModel
import com.joblogic.test.presentation.feature.home.action.call.CallViewModel
import com.joblogic.test.presentation.feature.home.action.sell.SellViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { BackStackViewModel() }
    viewModel { ActionViewModel() }
    viewModel { CallViewModel(get()) }
    viewModel { SellViewModel(get()) }
    viewModel { BuyViewModel(get(), get()) }
}