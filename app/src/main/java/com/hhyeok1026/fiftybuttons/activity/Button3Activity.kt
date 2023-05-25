package com.hhyeok1026.fiftybuttons.activity

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.hhyeok1026.fiftybuttons.databinding.ActivityButton3Binding
import com.hhyeok1026.fiftybuttons.uiState.Button3State
import com.hhyeok1026.fiftybuttons.viewmodel.Button3ViewModel

/*
viewmodel에서 state를 넣고, 가시성을 수정한 예제
 */
class Button3Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButton3Binding
    private val viewModel: Button3ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButton3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonStateObserver = Observer<Button3State> { button3State ->
            Log.d("Button3Activity", "button3State : {$button3State}")
            binding.button.text = button3State.text
            val tint = ContextCompat.getColor(this, button3State.tint)
            binding.button.backgroundTintList = ColorStateList.valueOf(tint)
        }
        viewModel.buttonState.observe(this, buttonStateObserver)

        binding.button.setOnClickListener {
            viewModel.toggleButtonState()
        }
    }
}