package com.example.a6m1hw.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    protected val loading : MutableLiveData<Boolean> = MutableLiveData()
}