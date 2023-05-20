package com.hhyeok1026.fiftybuttons.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.hhyeok1026.fiftybuttons.databinding.ActivityButton2Binding
import com.hhyeok1026.fiftybuttons.viewmodel.Button2ViewModel

/*
뷰 모델을 하나 붙이고,
뷰모델에 버튼의 State를 넣어서
버튼을 누를때마다
버튼의 text가 변화 되도록 하는 액티비티
 */
class Button2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityButton2Binding

    /*
        by viewModel()을 사용하려면,
        implementation 'androidx.activity:activity-ktx:1.7.1'
        또는
        implementation 'androidx.fragment:fragment-ktx:1.5.7'
        같은 디펜던시를 줘야함.
    */
    private val viewModel: Button2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButton2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonTextObserver = Observer<String> { newButtonText: String ->
            binding.button.text = newButtonText
        }
        viewModel.buttonText.observe(this, buttonTextObserver)

        binding.button.setOnClickListener {
            Toast.makeText(applicationContext, "버튼을 클릭했다", Toast.LENGTH_SHORT).show()
            viewModel.changeButtonText()
        }
    }
}