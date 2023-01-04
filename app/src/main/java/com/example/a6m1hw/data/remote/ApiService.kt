package com.example.a6m1hw.data.remote

import com.example.a6m1hw.BuildConfig
import com.example.a6m1hw.`object`.Constant
import com.example.a6m1hw.model.Playlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String = Constant.PART,
        @Query("channelId") channelId: String = Constant.CHANNEL_ID,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("part") part: String = Constant.PART,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
    ): Response<Playlist>
}