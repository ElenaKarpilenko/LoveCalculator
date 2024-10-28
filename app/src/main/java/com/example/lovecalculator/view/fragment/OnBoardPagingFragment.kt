package com.example.lovecalculator.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lovecalculator.databinding.FragmentOnBoardPagingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }


    private fun initialize() = with(binding) {
        Log.d("onBoard","fghjk")
        val position = arguments?.getInt(ARG_ONBOARD_POSITION) ?: 0
        when (position) {
            0 -> {
                tvOn.text = "It’s fun and many more"
            }
            1 -> {
                tvOn.text = "Have a good time. You should take the time to help those who need you"
            }
            2 -> {
                tvOn.text = "Cherishing love. It is now no longer possible for you to cherish love"
            }
        }

    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}