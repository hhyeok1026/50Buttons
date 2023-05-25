package com.hhyeok1026.fiftybuttons.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hhyeok1026.fiftybuttons.R
import com.hhyeok1026.fiftybuttons.databinding.ActivityButton4Binding

/*
fragment를 만들고, fragment내부에 버튼을 만들 예제

생명주기를 관찰하자.
 */

class Button4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButton4Binding

    // 위아래 상관없음
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Button4Activity", "Button4Activity - onCreate() - 위쪽")
        super.onCreate(savedInstanceState)
        Log.d("Button4Activity", "Button4Activity - onCreate() - 아래쪽")

        binding = ActivityButton4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // onDestroy()로 가게 만들기
        // finish()
    }

    // 위아래 상관없음
    override fun onStart() {
        Log.d("Button4Activity", "Button4Activity - onStart() - 위쪽")
        super.onStart()
        Log.d("Button4Activity", "Button4Activity - onStart() - 아래쪽")
    }

    // 위아래 상관없음
    override fun onResume() {
        Log.d("Button4Activity", "Button4Activity - onResume() - 위쪽")
        super.onResume()
        Log.d("Button4Activity", "Button4Activity - onResume() - 아래쪽")
    }

    // 위아래 상관없음
    override fun onPause() {
        Log.d("Button4Activity", "Button4Activity - onPause() - 위쪽")
        super.onPause()
        Log.d("Button4Activity", "Button4Activity - onPause() - 아래쪽")
    }

    // 위아래 상관없음
    override fun onStop() {
        Log.d("Button4Activity", "Button4Activity - onStop() - 위쪽")
        super.onStop()
        Log.d("Button4Activity", "Button4Activity - onStop() - 아래쪽")
    }

    // 위아래 상관없음
    override fun onRestart() {
        Log.d("Button4Activity", "Button4Activity - onRestart() - 위쪽")
        super.onRestart()
        Log.d("Button4Activity", "Button4Activity - onRestart() - 아래쪽")
    }

    // onCreate에서 finish()를 호출하면, 위쪽 아래쪽 다 됨.
    // recent버튼으로 날리면, 위쪽 코드만 실행되었음.
    override fun onDestroy() {
        Log.d("Button4Activity", "Button4Activity - onDestroy() - 위쪽")
        super.onDestroy()
        Log.d("Button4Activity", "Button4Activity - onDestroy() - 아래쪽")
    }





}