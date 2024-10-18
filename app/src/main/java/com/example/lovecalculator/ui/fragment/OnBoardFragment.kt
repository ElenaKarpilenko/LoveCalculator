package com.example.lovecalculator.ui.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentOnBoardBinding
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lovecalculator.R


class OnBoardFragment : Fragment() {

    private val binding by lazy {
        FragmentOnBoardBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }
    private fun initialize() {
        val viewPager2 = binding.viewPager2
        binding.viewPager2.adapter = OnBoardingAdapter(this)
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3) {
                    binding.startButton.visibility = View.VISIBLE
                } else {
                    binding.startButton.visibility = View.INVISIBLE

                }
            }
        })
        binding.startButton.setOnClickListener {
            if (currentItem < 4) {
                setCurrentItem(currentItem + 3)
            }
        }
        binding.startButton.setOnClickListener{
            findNavController().navigate(R.id.startFragment)
        }
    }
}