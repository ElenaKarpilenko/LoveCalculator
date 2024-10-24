package com.example.lovecalculator.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.R
import com.example.lovecalculator.data.pref.Pref
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    @Inject
    lateinit var sharedPreferences: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        btnGetStarted()
    }


    private fun initialize() {
        binding.viewPager2.adapter = OnBoardingAdapter(this@OnBoardFragment)
    }


    private fun setupListener() = with(binding.viewPager2) {
        Log.d("OnBoardFragment", "Button clicked")
        binding.startButton.setOnClickListener {
            sharedPreferences.setOnboardingComplete(true)
            findNavController().navigate(R.id.startFragment)
        }
    }

    private fun btnGetStarted() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        startButton.isVisible = false
                    }

                    1 -> {
                        startButton.isVisible = false
                    }

                    2 -> {
                        startButton.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

}