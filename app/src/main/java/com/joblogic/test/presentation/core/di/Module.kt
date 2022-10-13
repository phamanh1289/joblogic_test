package com.joblogic.test.presentation.core.di

import com.joblogic.test.presentation.core.base.BaseApplication
import org.koin.dsl.module

val appModule = module {
    single { BaseApplication.instance }
}