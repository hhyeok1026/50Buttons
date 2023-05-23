package com.hhyeok1026.fiftybuttons.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel // 현재 viewmodel 2.6.1버전

/*
    // viewmodel 참고
    https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko

    // livedata 참고
    https://developer.android.com/topic/libraries/architecture/livedata?hl=ko

    _TODO
     여기서, viewmodel과 liveData의 역할이 다를텐데,
     무슨차이가 있는건지 공식문서를 좀 보면서 알아봐야겠다.

    'ViewModel은 수명주기를 고려하여 ui관련 데이터를 저장하고 관리하도록 설계된 클래스
    뷰모델의 전반적인 라이프사이클이 중요한듯?

    'LiveData' 는 데이터 홀더하는 클래스이고, 수명주기를 인식한다.
    활동 수명주기에 있는 옵저브만 업데이트하게 함.
    기본적으로 기본 스레드에서 작동하고 비동기 스트림을 다뤄야하는것에는 적합하지 않다.
    잘못구현하면 기본스레드를 차단하게 됨.

    --------------------------------------------

    _TODO : by lazy {} 에 대해서도 공부해야함

    lateinit var : 원시값은 초기화 불가, var에 대해서 초기화
    by lazy : var는 쓸 수 없고, val을 초기화 할 때씀, 나중에 초기화되는 값에 대해서 다음 초기화를 할때 쓸 수 있다?

    --------------------------------------------

    (대강 알아보았다.)
    -> 블로그에 포스팅 하였음. ( https://hhyeok1026.tistory.com/82 )

    _TODO CharSequence와 String의 차이점은 뭘까? -> 대충보니까 CharSequence가 인터페이스고 String은 CharSequence를 구현하는 클래스인듯?

    'String'
    클래스, 문자열 작성 후 변경 불가능.
    문자열은 유니코드로 변형, HTML같은 마크업 문자는 문제발생함. aka 변경 할 수 없는 문자열.

    'CharSequence'
    인터페이스, char값을 읽을 수 있는 시퀀스.
    문자열이 유니코드라고 하더라도, 마크업 문자를 사용할 수 있다고 한다? (X, 개소리)
    String과 반대로 변형과 가공을 할 수 있기 때문에(이 설명자체가 넌센스인데?), 스타일문자, 연속된 문자라 한다? (X, 쌉소리)
    -> 대강, String에 비해서 제약이 적다라고 생각하고 있어야겠다.
    그리고 xml에 있는 값을 가져올때는 CharSequence를 쓰는게 맞는거 같긴 하다?

    _TODO
    -> 애초에 클래스와 인터페이스를 비교하는게 이해가 안되는데,
    인터페이스가 구현이 안되고 자기혼자 쓸 수 있다는건가? 인터페이스가 뭔지 공부를 해야겠는데..?

    이거를 이해하려면,
    문자열리터럴은 String으로 인스턴스 된다는거
    인터페이스 클래스 차이점
    특정 클래스(Button)에서 CharSeqeuce가 언제 인스턴스화 되는지,
    String <-> CharSeqeuce간에 업캐스팅, 다운캐스팅에 대해서 알고 있어야 설명이 가능함.

    -> ChatGPT에게 12번 물어보고 깨달았다.
    블로거들이 포스팅 해둔게 제대로 설명을 못하고 이해를 못하는 상황.
    인터페이스는 스스로 객체를 생성할 수 없지만, 인터페이스를 구현하는 클래스의 인스턴스를 가질 수는 있음.


    업캐스팅은 상위타입으로 더 일반적인 변환이므로 안전함.
    val buttonText: CharSequence = button.text에서의 대입은 업캐스팅입니다.
    (아니, 이미 button.text = "String"을 하면서 Charseqence로 업캐스팅 되었을 것이고, 그냥 대입 연산일것 같다?)

    업캐스팅, 다운캐스팅시, 데이터나 메모리 구조에는 관련을 주지않고, 보이는 자료형에만 영향을 주게 된다.
    업캐스팅이 안전하다는 말은, 업캐스팅 될 자료형을 기준으로, 업캐스팅 된 이후에 그 변수를 사용할 때 문제가 없음을 의미한다.

    다운캐스팅은 val buttonText: String = button.text as String
    CharSequence를 String으로 다운캐스팅하는 것은 안전하지 않음.
 */

class Button2ViewModel : ViewModel() {

    // 가시성이 private로 하지 않았고, 기본 가시성은 public이라서 좋지 않은 코드일 것이다.
    // (하긴했다. 맞는지 모르겠다)_TODO : 가시성(visibility modifiers)을 개선해야함 -> Button3Acitity에서 하자

    val buttonText: MutableLiveData<CharSequence> by lazy {
        // Log.d("Button2ViewModel", "lazy 하게 초기화 되는가 - 이게 무조건 바로 찍히는데, 이렇게 확인할게 아닌듯?")
        MutableLiveData<CharSequence>()
    }

    fun initializeButtonText(text: CharSequence) {
        // _TODO ui에 값이 초기값이 있을때, LiveData의 값을 초기화 시키는 좋은 방법은 뭘까??? (그냥 뷰모델에서 라이브데이터 값 만들때 초기화 하는게 나을듯??)
        buttonText.value = text
    }

    fun changeButtonText() {

        // Log.d("Button2ViewModel", "changeButtonText - buttonText.value : ${buttonText.value}")

        if (buttonText.value == "Button2") {
            // Log.d("Button2ViewModel", "changeButtonText - buttonText.value == Button")
            buttonText.value = "clicked"
        } else {
            // Log.d("Button2ViewModel", "changeButtonText - buttonText.value != Button")
            buttonText.value = "Button2"
        }
    }
}


// _TODO : 다음은 ButtonState 데이터 클래스를 만들어서 text를 변경해봐야겠다. -> Button3Acitivy에서 해보자. 하긴했다.. State값에 뭘 넣을지 고민을 해야한다.