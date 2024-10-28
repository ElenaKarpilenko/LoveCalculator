package com.example.lovecalculator.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName") ?: "You"
        val secondName = arguments?.getString("secondName") ?: "Me"
        val percentage = arguments?.getString("percentage") ?: "0"

        tvYouResult.text = firstName  // Используйте правильный идентификатор
        tvMeResult.text = secondName   // Используйте правильный идентификатор
        scorePercent.text = "$percentage%"

        btnTryAgain.setOnClickListener {  // Используйте правильный идентификатор для кнопки
            findNavController().navigate(R.id.historyFragment)
        }
    }
}
