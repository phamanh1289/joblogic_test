package com.joblogic.test.presentation.core.di

import com.joblogic.test.data.local.database.createDB
import com.joblogic.test.data.local.database.createItemDao
import org.koin.dsl.module

val databaseModule = module {
    single { createDB(get()) }
    single { createItemDao(get()) }
}