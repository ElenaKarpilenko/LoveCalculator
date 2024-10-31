package com.example.lovecalculator.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentCalculatorBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.viewmodel.CalculatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalculatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.loveResultData.observe(viewLifecycleOwner) { result ->
            navigateToResultFragment(result)
        }
        viewModel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun initListener() = with(binding) {
        calculateButton.setOnClickListener {
            val firstName = firstNameInput.text.toString()
            val secondName = secondNameInput.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            viewModel.getPercentage(firstName, secondName)
        }

    }


    private fun navigateToResultFragment(loveResult: LoveModel) {
        val bundle = Bundle().apply {
            putSerializable("calc_result", loveResult)
        }
        findNavController().navigate(R.id.action_calculatorFragment_to_resultFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}