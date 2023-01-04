package com.example.a6m1hw.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.a6m1hw.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dao():PlaylistDao
}