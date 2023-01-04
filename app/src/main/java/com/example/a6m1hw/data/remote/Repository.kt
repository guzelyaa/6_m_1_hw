package com.example.a6m1hw.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.a6m1hw.model.Playlist
import com.example.a6m1hw.network.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylist(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylist()

        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getPlaylistItems(playlistId: String): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = apiService.getPlaylistItems(playlistId = playlistId)

            if (result.isSuccessful) {
                emit(Resource.success(result.body()))
            } else {
                emit(Resource.error(result.message()))
            }
        }
}