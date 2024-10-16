package com.example.lovecalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                tvTheme.text = "Очень удобный функционал"
                tvDescription.text = "Очень удобный функционал"
            }

            1 -> {
                tvTheme.text = "Быстрый, качественный продукт"
                tvDescription.text = "Очень удобный функционал"

            }

            2 -> {
                tvTheme.text = "Куча функций и интересных фишек"
                tvDescription.text = "Очень удобный функционал"

            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}