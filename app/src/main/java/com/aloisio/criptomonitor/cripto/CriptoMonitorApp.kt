package com.aloisio.criptomonitor.cripto

import android.app.Application
import com.aloisio.criptomonitor.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CriptoMonitorApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@CriptoMonitorApp)
            androidLogger()

            modules(appModule)
        }
    }
}