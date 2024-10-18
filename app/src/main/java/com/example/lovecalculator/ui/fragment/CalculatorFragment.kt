package com.example.lovecalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.data.LoveModel
import com.example.lovecalculator.data.RegistrationPresenter
import com.example.lovecalculator.data.RegistrationView
import com.example.lovecalculator.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(),RegistrationView {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var presenter: RegistrationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = RegistrationPresenter(this)

        binding.calculateButton.setOnClickListener {
            val firstName = binding.firstNameInput.text.toString()
            val secondName = binding.secondNameInput.text.toString()

            presenter.calculatePercentage(firstName, secondName)
        }
    }

    override fun showLoading() {
        binding.calculateButton.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.calculateButton.visibility = View.GONE
    }

    override fun showSuccessResult(result: LoveModel) {
        val action =  CalculatorFragmentDirections.actionCalculatorFragmentToResultFragment(
            result.percentage.toString())
        findNavController().navigate(action)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
    }
}





