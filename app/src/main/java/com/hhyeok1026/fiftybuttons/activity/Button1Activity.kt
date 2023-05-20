package com.hhyeok1026.fiftybuttons.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hhyeok1026.fiftybuttons.databinding.ActivityButton1Binding

/*
i just make a one Button for first start!

버튼하나, 뷰바인딩을 사용, 클릭리스너를 하나 붙였다.
 */
class Button1Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButton1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButton1Binding.inflate(layoutInflater)
        val view = binding.root
        //setContentView(R.layout.activity_button1)
        setContentView(view)

        binding.button.setOnClickListener {
            Toast.makeText(applicationContext, "버튼을 눌렀다", Toast.LENGTH_SHORT).show()
        }
    }
}