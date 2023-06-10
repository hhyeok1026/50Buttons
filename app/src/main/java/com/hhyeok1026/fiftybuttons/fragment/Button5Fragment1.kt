package com.hhyeok1026.fiftybuttons.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
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
    ): View? {
        _binding = Fragment1Button5Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}