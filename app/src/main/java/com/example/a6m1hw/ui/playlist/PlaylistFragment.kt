package com.example.a6m1hw.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a6m1hw.R
import com.example.a6m1hw.base.BaseFragmentt
import com.example.a6m1hw.databinding.FragmentPlaylistBinding
import com.example.a6m1hw.ui.playlist.adapter.PlaylistAdapter
import com.example.a6m1hw.utils.isOnline

class PlaylistFragment : BaseFragmentt<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun checkInternet() {
        val online = isOnline(requireContext())
        binding.recyclerPlaylist.isVisible = online
        binding.noInternetContainer.isVisible = !online
    }

    override fun initListener() {
        super.initListener()
        binding.noInternet.tryAgain.setOnClickListener {
            checkInternet()
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylist().observe(viewLifecycleOwner) {
            Log.e("ololo", "initViewModel: " + it)
            adapter.addData(it.items)
        }
        binding.recyclerPlaylist.adapter = adapter
    }

    private fun onClick(id: String) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }

}