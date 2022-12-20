package com.example.a6m1hw.ui.playlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6m1hw.BuildConfig.API_KEY
import com.example.a6m1hw.BuildConfig.BASE_URL
import com.example.a6m1hw.R
import com.example.a6m1hw.base.BaseFragment
import com.example.a6m1hw.databinding.FragmentPlaylistBinding

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return  FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylist().observe(viewLifecycleOwner){
            Log.e("ololo", "initViewModel: "+it )
        }
    }

}