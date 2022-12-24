package com.example.a6m1hw.data.remote

import com.example.a6m1hw.BuildConfig
import com.example.a6m1hw.`object`.Constant
import com.example.a6m1hw.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylist(
        @Query("part") part: String = Constant.PART,
        @Query("channelId") channelId: String = Constant.CHANNEL_ID,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query("part") part: String = Constant.PART,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
    ): Call<Playlist>
}