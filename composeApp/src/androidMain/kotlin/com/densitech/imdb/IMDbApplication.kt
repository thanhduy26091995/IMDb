package com.densitech.imdb

import android.app.Application
import di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class IMDbApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(androidContext = this@IMDbApplication.applicationContext)
        }
    }
}