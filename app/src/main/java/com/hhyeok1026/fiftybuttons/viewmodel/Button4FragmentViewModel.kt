package com.hhyeok1026.fiftybuttons.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*
화면 회전을 해도 뷰모델의 값이 계속 유지가 되는데,
대충 봐서는 onDestory()이후로 finished?까지 가야지
onCleared()가 호출된다는 말인듯한데

fragment가 onDetach만 되도 뷰모델이 사라질 수 있다는 뉘앙스의 문구가
공식문서에 또 있기도 하고..
이게 경우에 따라 좀 다른건가 싶은데

뷰모델을 제대로 다루려면 테스트.. 예제들을 더 많이 해야하는거 같다.

일단 뷰모델이 없어지는지 보려면 onCleared()를 봐야할듯하다.
 */
class Button4FragmentViewModel : ViewModel() {

    /*
        _TODO : android개발에서, viewmodel 내에서 그냥 변수를 쓰는 것과 livedata를 쓰는 것의 차이는 뭐가 있을까?
        생명주기때문에 ui가 날라가고
        -> 이거 데이터는 유지하고 있기는한데, settext하는 부분을 따로 적어야하고,
        livedata는 데이터 옵저브하고 있어야함.

        단순하게 ui에서 <-> viewmodel사이에서
        이벤트오고 반영해주는거는 굳이 livedata를 안써도 구현이 될듯하고,

        viewdel에서 repository나 다른곳과 계산해서 뭔가 반영을 해야하는 경우에
        라이브데이터를 써야하는듯?

        옵저버 차이라고 해야하나?
        라이브데이터가 옵저버말고도 데이터에 자체적으로 라이프사이클을 먹이는 것도 있는듯하네.



        _TODO : livedata는 왜 value값으로 접근을 해야하지?
        ->  그냥 그런가보다 해야겠다.
        mdata: Object값이 들어가있고 setValue, getValue메서드로 그 값 가져오게 되는 거니까
     */

    var btnCount: Int = 0

    val btnCountLiveData : MutableLiveData<Int> = MutableLiveData(0)
    val btnCountLiveData2 : LiveData<Int> = btnCountLiveData

    fun increaseBtn4IntCount() {
        btnCount++
    }

    fun increaseBtn4LivedataCount() {
        btnCountLiveData.value = btnCountLiveData.value?.plus(1)
        btnCountLiveData2.value
    }

    override fun onCleared() {
        Log.v("Button4FragmentViewModel", "onCleared()가 호출됨. - 위쪽")
        super.onCleared()
        Log.v("Button4FragmentViewModel", "onCleared()가 호출됨. - 아래쪽")
    }
}