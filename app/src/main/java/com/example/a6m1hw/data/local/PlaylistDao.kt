package com.example.a6m1hw.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.a6m1hw.model.Playlist

@Dao
interface PlaylistDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertPlaylist(playlist:Playlist)

    @Query("SELECT * FROM playlist")
    suspend fun getPlaylist():Playlist?
}