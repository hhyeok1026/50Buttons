package com.hhyeok1026.fiftybuttons.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hhyeok1026.fiftybuttons.R
import com.hhyeok1026.fiftybuttons.databinding.Fragment2Button5Binding
import com.hhyeok1026.fiftybuttons.viewmodel.Button5Fragment2ViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [Button5Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Button5Fragment2 : Fragment() {

    private var _binding: Fragment2Button5Binding? = null
    private val binding: Fragment2Button5Binding
        get() = _binding!!

    private val viewModel: Button5Fragment2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2Button5Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button52.setOnClickListener {
            // findNavController().navigate(R.id.action_button5Fragment2_to_button5Fragment1)

            // navigateUp과 popBackStack()은 의미가 약간 다르다고 한다.
            // findNavController().navigateUp()
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}