package com.joblogic.test.presentation.core.di

import com.joblogic.test.data.remote.repoImpl.MainRepoImpl
import com.joblogic.test.domain.repo.MainRepo
import org.koin.dsl.module

val repoModule = module{
    single<MainRepo> { MainRepoImpl(get(), get()) }
}