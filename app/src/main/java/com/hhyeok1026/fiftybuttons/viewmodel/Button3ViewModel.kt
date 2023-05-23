package com.hhyeok1026.fiftybuttons.viewmodel

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hhyeok1026.fiftybuttons.R
import com.hhyeok1026.fiftybuttons.uiState.Button3State

class Button3ViewModel : ViewModel() {

    /*
     (다음에.. 언젠가 해야할때 적용하자, 이제 프레그먼트, 네비게이션도 공부해야함)
     _TODO 근데, 이렇게 text, tint를 State에 넣는거는 이상한거 같다.

     Button의 클릭유무만 가지고 있고,
     tint랑 text는 클릭에 따라서 파생되어지는 값이니까, 그냥 observe에서 click값 보고 바꾸는게 나을듯.
     */
    private val _buttonState = MutableLiveData<Button3State>(
        Button3State(
            isClicked = false,
            text = "Click Me",
            tint = R.color.purple_500
        )
    )

    /*
     이렇게 하는걸 backing property라고 하나?
     _가 붙은게 private로 해당 파일 내에서만 쓰고,
     다른 파일에서 써야할 변수는 get만 사용 할 수있는 public val변수로 해둬서 읽기만 할 수 있게 만드는거

     근데, 지금 내가 구현한게 setter메서드를 열어 놨는데 이게 의미가 있나 싶다.
     setter 메서드말고, 그냥 뷰모델에서 초기화 하는게 낫겠고 삭제했음.
    */
    val buttonState: LiveData<Button3State>
        get() {
            // 이게 보니까, 이 블록이 바뀔때마다 동작하는게 아니라 한번 등록하고 끝이네
            Log.d("Button3ViewModel", "buttonState의 get()이 작동하였음.")
            return _buttonState
        }

    fun toggleButtonState() {

        val currentState = _buttonState.value

        Log.d("Button3ViewModel", "currentState : ${currentState}")

        if (currentState != null) {
            val updatedState = currentState.copy(
                isClicked = !currentState.isClicked,

                // 여기에 currentState가 boolean으로 들어오니, if문이 겁나 겁나 어려워졌다, 코드가 깔끔해져서 좋긴한데..
                // 처음이 false일때랑, true일때를 생각해서 머릿속으로 굴려야 맞출수 있다.. 산수 잘못해서 계산 이상하게 되는 넌센스 수학문제 같다..
                text = if (currentState.isClicked) "Click Me" else "Clicked",
                tint = if (currentState.isClicked) R.color.purple_500 else R.color.teal_200 // 클릭 여부에 따른 tint 색상 리소스
            )

            // 라이브데이터를 다시 업데이트 할때는 value를 통째로 재할당시켜야함.
            // value뒤에 찍어서 나오는 프로퍼티는 읽기 전용임.
            // value를 set하는거는 통째로 새로운 객체할당이다.
            // 그래서 기존값에서 copy를 써서 바꿀값만 바꿔서 객체를 새로 만드는거였다.
            _buttonState.value = updatedState
            // _buttonState.value?.text // getValue는 LiveData에 있는거고, setValue는 mutableLivedata에 있다.
        }
    }
}