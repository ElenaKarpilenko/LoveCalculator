package com.example.lovecalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.data.LoveModel
import com.example.lovecalculator.data.RegistrationPresenter
import com.example.lovecalculator.data.RegistrationView
import com.example.lovecalculator.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(), RegistrationView.View {

    private lateinit var binding: FragmentCalculatorBinding
    private val presenter = RegistrationPresenter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculateButton.setOnClickListener {
            val firstName = binding.firstNameInput.text.toString()
            val secondName = binding.secondNameInput.text.toString()

            if (firstName.isBlank() || secondName.isBlank()) {
                Toast.makeText(requireContext(), "Enter both names", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            presenter.getPercentage(firstName, secondName)
        }
    }

    override fun showResult(result: LoveModel) {
        val percentage = result.percentage?.toIntOrNull() ?: 0
        val bundle = Bundle().apply {
            putString("firstName", result.firstName)
            putString("secondName", result.secondName)
            putInt("percentage", percentage)
        }
        findNavController().navigate(R.id.action_calculatorFragment_to_resultFragment, bundle)
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}