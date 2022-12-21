package com.example.a6m1hw.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6m1hw.base.BaseFragmentt
import com.example.a6m1hw.databinding.FragmentPlaylistBinding

class PlaylistFragment : BaseFragmentt<FragmentPlaylistBinding, PlaylistViewModel>() {

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