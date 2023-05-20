package com.hhyeok1026.fiftybuttons.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel // 현재 viewmodel 2.6.1버전



/*

// viewmodel 참고
https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko

// livedata 참고
https://developer.android.com/topic/libraries/architecture/livedata?hl=ko

 */

class Button2ViewModel : ViewModel() {

    // 가시성이 private로 하지 않았고, 기본 가시성은 public이라서 좋지 않은 코드일 것이다.
    // TODO : 가시성(visibility modifiers)을 개선해야함
    val buttonText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun changeButtonText() {
        if (buttonText.value == "Button") {
            buttonText.value = "clicked"
        } else {
            buttonText.value = "Button"
        }
    }
}

/*
    TODO :
     여기서, viewmodel과 liveData의 역할이 다를텐데,
     무슨차이가 있는건지 공식문서를 좀 보면서 알아봐야겠다.
 */

// TODO : 다음은 ButtonState 데이터 클래스를 만들어서 text를 변경해봐야겠다. ?