package com.hhyeok1026.fiftybuttons.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


// navigation을 하고나면, onCleared는 호출이 되지 않았는데,
// init은 되고 값이 초기화 됨.

class Button5Fragment1ViewModel : ViewModel() {

    val btnCountLiveData: MutableLiveData<Int> = MutableLiveData(0)

    /*
    val btnCountLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData(0)
    }*/

    init {
        Log.d("Button5Fragment1ViewModel", "init 호출됨")
    }
    fun increaseBtnCountLiveData() {
        btnCountLiveData.value = btnCountLiveData.value?.plus(1)
    }

    override fun onCleared() {
        Log.d("Button5Fragment1ViewModel", "onCleared() 호출됨")
        super.onCleared()
        Log.d("Button5Fragment1ViewModel", "onCleared() 호출됨")
    }
}