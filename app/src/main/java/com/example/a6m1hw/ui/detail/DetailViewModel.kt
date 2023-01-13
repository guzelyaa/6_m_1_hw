package com.example.a6m1hw.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a6m1hw.base.BaseViewModel
import com.example.a6m1hw.data.remote.ApiService
import com.example.a6m1hw.data.remote.Repository
import com.example.a6m1hw.model.Playlist
import com.example.a6m1hw.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val repo: Repository) : BaseViewModel() {

    fun getPlaylistItem(id:String) = repo.getPlaylistItems(id)

}