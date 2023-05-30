package com.hhyeok1026.fiftybuttons.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
// import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hhyeok1026.fiftybuttons.databinding.FragmentButton4Binding
import com.hhyeok1026.fiftybuttons.viewmodel.Button4FragmentViewModel


/*
Fragment생명주기가, 한국어문서는 관리가 안되고 있고, 영어문서는 설명이 뭔가 더 어렵게 되어있네..?
영어문서를 이해를 해야할텐데..
lifecycle owner, lifecycle satate?에 대해서도 알아야 할 듯.

한국어 - https://developer.android.com/guide/components/fragments?hl=ko#Lifecycle
영어 - https://developer.android.com/guide/fragments/lifecycle

Downward state transitions에서,
STARTED, CREATED 된다는게 이해가 안되는데..? -> 이거는 따로, 라이프사이클 state, 라이프사이클 오너 쪽을 봐야 이해가 될 듯.


액티비티에서 생명주기의 위쪽 아래쪽에 넣어둔 로그들이 <-> 프래그먼트와도 연관이 뭔가 있다..!
복잡하므로 필요할때 이거 돌려보고 이해해야 할 듯.


_TODO fragment에서 뷰모델 초기화를 어디서하나?
 힐트를 쓰면 그냥 바로 필드변수로 쓰는거 같은데..?
 -> fragment도 그냥 액티비티에서 by로 만들어서 쓰면 되는듯.
 */

class Button4Fragment : Fragment() {

    private var _binding: FragmentButton4Binding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // by viewModels()를 fragement에서 쓰려면, fragemnt-ktx에서 가져와야하는듯.
    private val viewModel: Button4FragmentViewModel by viewModels()

    // =============================================
    // Activity State - Created
    // =============================================

    override fun onAttach(context: Context) {
        Log.d("Button4Fragment", "Button4Fragment - onAttach() - 위쪽")
        super.onAttach(context)
        Log.d("Button4Fragment", "Button4Fragment - onAttach() - 아래쪽")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Button4Fragment", "Button4Fragment - onCreate() - 위쪽")
        super.onCreate(savedInstanceState)
        Log.d("Button4Fragment", "Button4Fragment - onCreate() - 아래쪽")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Button4Fragment", "Button4Fragment - onCreateView()")

        _binding = FragmentButton4Binding.inflate(inflater, container, false)
        return binding.root
    }

    // Activity 의 onCreate()가 반환되면, 호출 된다.
    // -> 액티비티가 onStart()되면 -> 이 onActivityCreated가 실행되고 -> 그다음에 fragment의 start가 실행되고, -> 다시 액티비티의 onStart가 마무리됨..
    // -> deprecated 된거 같고, onViewCreated를 쓰라는듯?
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Button4Fragment", "Button4Fragment - onActivityCreated() - 위쪽")
        super.onActivityCreated(savedInstanceState)
        Log.d("Button4Fragment", "Button4Fragment - onActivityCreated() - 아래쪽")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Button4Fragment", "Button4Fragment - onViewCreated() - 위쪽")
        super.onViewCreated(view, savedInstanceState)
        Log.d("Button4Fragment", "Button4Fragment - onViewCreated() - 아래쪽")

        binding.button4Int.text = viewModel.btnCount.toString()
        binding.button4Int.setOnClickListener {
            Toast.makeText(context, "버튼int을 눌렀다", Toast.LENGTH_SHORT).show()
            viewModel.increaseBtn4IntCount()
            binding.button4Int.text = viewModel.btnCount.toString()
        }


        // _TODO fragment에서는 왜 LifecycleOwner에 viewLifecycleOwner를 넣어야하는가? -> viewLifecycleOwner를 따르게 하려고.
        // -> 프루님 블로그에 언급이 있는거 같던데, 안봐도 대강 느낌은 알겠는데, 나중에 블로그를 읽어보자.
        // -> 구글 문서에 lifecycles문서를 예전에는 아에 이해를 못했는데, 이번에 그 문서를 보니 약간 느낌을 알것 같다.
        viewModel.btnCountLiveData.observe(viewLifecycleOwner, Observer {
            binding.button4Livedata.text = it.toString()
        })
        binding.button4Livedata.setOnClickListener {
            Toast.makeText(context, "버튼livedata을 눌렀다", Toast.LENGTH_SHORT).show()
            viewModel.increaseBtn4LivedataCount()
        }

    }

    // =============================================
    // Activity State - Created
    // =============================================


    // =============================================
    // Activity State - Started
    // =============================================

    override fun onStart() {
        Log.d("Button4Fragment", "Button4Fragment - onStart() - 위쪽")
        super.onStart()
        Log.d("Button4Fragment", "Button4Fragment - onStart() - 아래쪽")
    }

    // =============================================
    // Activity State - Started
    // =============================================


    // =============================================
    // Activity State - Resumed
    // =============================================

    override fun onResume() {
        Log.d("Button4Fragment", "Button4Fragment - onResume() - 위쪽")
        super.onResume()
        Log.d("Button4Fragment", "Button4Fragment - onResume() - 아래쪽")
    }

    // =============================================
    // Activity State - Resumed
    // =============================================



    // =============================================
    // Activity State - Paused
    // =============================================

    override fun onPause() {
        Log.d("Button4Fragment", "Button4Fragment - onPause() - 위쪽")
        super.onPause()
        Log.d("Button4Fragment", "Button4Fragment - onPause() - 아래쪽")
    }

    // =============================================
    // Activity State - Paused
    // =============================================


    // =============================================
    // Activity State - Stopped
    // =============================================

    override fun onStop() {
        Log.d("Button4Fragment", "Button4Fragment - onStop() - 위쪽")
        super.onStop()
        Log.d("Button4Fragment", "Button4Fragment - onStop() - 아래쪽")
    }

    // =============================================
    // Activity State - Stopped
    // =============================================


    // =============================================
    // Activity State - Destroyed
    // =============================================

    override fun onDestroyView() {

        _binding = null
        Log.d("Button4Fragment", "Button4Fragment - onDestroyView() - 위쪽")
        super.onDestroyView()
        Log.d("Button4Fragment", "Button4Fragment - onDestroyView() - 아래쪽")

    }

    override fun onDestroy() {
        Log.d("Button4Fragment", "Button4Fragment - onDestroy() - 위쪽")
        super.onDestroy()
        Log.d("Button4Fragment", "Button4Fragment - onDestroy() - 아래쪽")
    }

    override fun onDetach() {
        Log.d("Button4Fragment", "Button4Fragment - onDetach() - 위쪽")
        super.onDetach()
        Log.d("Button4Fragment", "Button4Fragment - onDetach() - 아래쪽")
    }

    // =============================================
    // Activity State - Destroyed
    // =============================================
}