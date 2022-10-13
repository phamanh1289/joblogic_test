package com.joblogic.test.presentation.core.base

import android.app.Application
import com.joblogic.test.presentation.core.di.*
import com.joblogic.test.presentation.other.dialog.LoadingDialog
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    private var _loadingDialog = lazy { LoadingDialog() }
    val loadingDialog: LoadingDialog
        get() = _loadingDialog.value

    companion object {
        lateinit var instance: BaseApplication private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initialKoin()
    }

    private fun initialKoin() {
        startKoin {
            androidContext(instance)
            modules(
                listOf(
                    appModule,
                    databaseModule,
                    networkModule,
                    repoModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}