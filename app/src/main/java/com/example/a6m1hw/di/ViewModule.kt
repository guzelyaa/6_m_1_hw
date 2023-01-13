package com.example.a6m1hw.di

import com.example.a6m1hw.ui.detail.DetailViewModel
import com.example.a6m1hw.ui.playlist.PlaylistViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel{PlaylistViewModel(get())}
    viewModel{DetailViewModel(get())}
}