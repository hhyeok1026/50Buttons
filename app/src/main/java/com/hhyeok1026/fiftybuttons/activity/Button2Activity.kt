package com.hhyeok1026.fiftybuttons.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
/*
    화면이 처음뜨고나서 클릭하면, 바로 작동하지 않고
    다시 눌러야지 클릭이 되는 버그가 있다.

    초기화시, viewModel에서 buttonText값이 null이라서 발생하는 문제.
    -> 일단, 고쳐두긴 했는데 더 좋은 방법이 있을듯하다.
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

        Log.d("Button2Activity", "Button2Activity - onCreate")

        binding = ActivityButton2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val buttonTextObserver = Observer<CharSequence> { newButtonText: CharSequence ->
            binding.button.text = newButtonText
        }

        // Log.d("Button2Activity", "1 viewModel.buttonText.value: ${viewModel.buttonText.value}") // null로 찍힘
        viewModel.buttonText.observe(this, buttonTextObserver)
        // Log.d("Button2Activity", "2 viewModel.buttonText.value: ${viewModel.buttonText.value}") // null로 찍힘
        viewModel.initializeButtonText(binding.button.text)
        // Log.d("Button2Activity", "3 viewModel.buttonText.value: ${viewModel.buttonText.value}") // 초기화 됨.

        binding.button.setOnClickListener {
            Log.d("Button2Activity", "Button2Activity - setOnClickListener")
            Toast.makeText(applicationContext, "버튼을 클릭했다", Toast.LENGTH_SHORT).show()
            viewModel.changeButtonText()
        }
    }
}