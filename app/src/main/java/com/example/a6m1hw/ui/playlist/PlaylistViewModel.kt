package com.example.a6m1hw.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.a6m1hw.base.BaseViewModel
import com.example.a6m1hw.data.remote.ApiService
import com.example.a6m1hw.data.remote.Repository
import com.example.a6m1hw.data.remote.RetrofitClient
import com.example.a6m1hw.model.Playlist
import com.example.a6m1hw.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {
    private val repo = Repository()

    private val setPlaylistLiveData = MutableLiveData<Playlist>()

    val setPlaylistDB = setPlaylistLiveData.switchMap {
        repo.setPlaylistDB(it)
    }

    val getPlaylist: LiveData<Resource<Playlist>> = repo.getPlaylist()

    val getPlaylistDB: LiveData<Resource<Playlist>> = repo.getPlaylistDB()

    fun setPlaylistDB(playlist: Playlist) {
        setPlaylistLiveData.postValue(playlist)
    }
}