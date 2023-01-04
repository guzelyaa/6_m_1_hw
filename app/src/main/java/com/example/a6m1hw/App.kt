package com.example.a6m1hw

import android.app.Application
import androidx.room.Room

import com.example.a6m1hw.data.local.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room
            .databaseBuilder(applicationContext, AppDatabase::class.java, "play;ist.db")
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}