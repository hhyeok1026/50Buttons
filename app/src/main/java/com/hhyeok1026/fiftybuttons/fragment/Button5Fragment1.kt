package com.hhyeok1026.fiftybuttons.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hhyeok1026.fiftybuttons.viewmodel.`Button5-1FragmentViewModel`
import com.hhyeok1026.fiftybuttons.R

class Button5_1Fragment : Fragment() {

    private lateinit var viewModel: `Button5-1FragmentViewModel`

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button5, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(`Button5-1FragmentViewModel`::class.java)
        // TODO: Use the ViewModel
    }

}