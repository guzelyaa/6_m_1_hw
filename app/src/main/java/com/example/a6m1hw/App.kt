package com.example.a6m1hw

import android.app.Application
import androidx.room.Room

import com.example.a6m1hw.data.local.AppDatabase
import com.example.a6m1hw.data.remote.networkModule
import com.example.a6m1hw.di.repoModules
import com.example.a6m1hw.di.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(arrayListOf(repoModules, viewModules, networkModule))
        }

        db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "playlist.db")
            .build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}