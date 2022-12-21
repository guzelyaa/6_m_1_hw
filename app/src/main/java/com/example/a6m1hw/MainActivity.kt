package com.example.a6m1hw

import BaseActivityt
import android.view.LayoutInflater
import com.example.a6m1hw.databinding.ActivityMainBinding

class MainActivity : BaseActivityt<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()

    }
}