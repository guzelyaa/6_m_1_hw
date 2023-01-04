package com.example.a6m1hw.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6m1hw.base.BaseFragment
import com.example.a6m1hw.databinding.FragmentDetailBinding


class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

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
        val id = arguments?.getString("id")
        viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner,{
            Log.e("ololo", "initView: "+it )
        })
    }



}