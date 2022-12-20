package com.example.a6m1hw.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

import com.example.a6m1hw.R

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(R.layout.activity_base)
        initView()
    }

    open fun initView(){}
}