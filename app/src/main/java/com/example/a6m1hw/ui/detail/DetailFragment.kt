package com.example.a6m1hw.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6m1hw.R
import com.example.a6m1hw.base.BaseFragment
import com.example.a6m1hw.databinding.FragmentDetailBinding
import com.example.a6m1hw.ui.playlist.PlaylistViewModel


class DetailFragment : BaseFragment<FragmentDetailBinding, PlaylistViewModel>() {
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

    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }


}