package com.example.a6m1hw.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a6m1hw.R
import com.example.a6m1hw.base.BaseFragment
import com.example.a6m1hw.databinding.FragmentDetailBinding
import com.example.a6m1hw.model.Item
import com.example.a6m1hw.network.Status
import com.example.a6m1hw.ui.detail.adapter.DetailAdapter
import com.example.a6m1hw.ui.playlist.adapter.PlaylistAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    private val adapter: DetailAdapter by lazy {
        DetailAdapter(this::onClick, requireContext())
    }

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initView() {
        val item = arguments?.getSerializable("item") as Item
        viewModel.getPlaylistItem(item.id.toString()).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    adapter.addData(it.data?.items)
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR -> {
                    viewModel.loading.value = false
                    Log.e("ololo", "initViewModel: " + it.msg)
                }
            }
        }
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
        val count = item.contentDetails?.itemCount
        binding.videoNumber.text = getString(R.string.video_count, count)
        binding.tvPlaylistName.text = item.snippet?.title
        binding.recyclerPlaylist.adapter = adapter
    }


    private fun onClick(item: Item) {

    }


}