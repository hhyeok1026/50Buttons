package com.hhyeok1026.fiftybuttons.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hhyeok1026.fiftybuttons.R
import com.hhyeok1026.fiftybuttons.databinding.ActivityButton3Binding

class Button3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButton3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButton3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            Toast.makeText(applicationContext, "버튼을 클릭했다", Toast.LENGTH_SHORT).show()
        }
    }
}