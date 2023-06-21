package com.hhyeok1026.fiftybuttons.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.hhyeok1026.fiftybuttons.viewmodel.Button5Fragment1ViewModel
import com.hhyeok1026.fiftybuttons.R
import com.hhyeok1026.fiftybuttons.databinding.Fragment1Button5Binding

class Button5Fragment1 : Fragment() {

    private var _binding: Fragment1Button5Binding? = null
    private val binding: Fragment1Button5Binding
        get() = _binding!!

    private val viewModel: Button5Fragment1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Button5Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.btnCountLiveData.observe(viewLifecycleOwner, Observer {

            if (it != 0) {
                binding.Button51.text = it.toString()
            }

            if (it == 3) {
                // popUpBackstack을 했을때, 이거 때문인지? navigation에 버그가 걸렸었음. 주의!
                // findNavController().navigate(R.id.action_button5Fragment1_to_button5Fragment2)
            }
        })

        binding.Button51.setOnClickListener {
            Toast.makeText(context, "Button5Fragment1의 버튼을 눌렀다", Toast.LENGTH_SHORT).show()

            viewModel.increaseBtnCountLiveData()

            // Navigation으로 쓰는 이거는 자바에서 사용하는 코드이다.
            // Navigation.createNavigateOnClickListener(R.id.action_button5Fragment1_to_button5Fragment2, null)
            findNavController().navigate(R.id.action_button5Fragment1_to_button5Fragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        Log.d("Button5Fragment1", "Button5Fragment1 - onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Button5Fragment1", "Button5Fragment1 - onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Button5Fragment1", "Button5Fragment1 - onDetach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Button5Fragment1", "Button5Fragment1 - onCreate()")
    }
}