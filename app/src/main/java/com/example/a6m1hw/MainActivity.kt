package com.example.a6m1hw

import android.view.LayoutInflater
import com.example.a6m1hw.databinding.ActivityMainBinding
import com.example.a6m1hw.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        super.initView()

    }
}