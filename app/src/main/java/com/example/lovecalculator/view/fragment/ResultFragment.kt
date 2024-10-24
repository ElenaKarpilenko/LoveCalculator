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

    private lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getString("percentage")

        tvFirstName.text = firstName
        tvSecondName.text = secondName
        scorePercent.text = "$percentage%"

        buttonTryAgain.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }
}