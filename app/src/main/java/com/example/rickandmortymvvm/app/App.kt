package com.example.rickandmortymvvm.app

import android.app.Application
import com.example.rickandmortymvvm.common.CommonModule
import com.example.rickandmortymvvm.main.ui.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(MainModule.create(), CommonModule.create())
        }
    }
}