package com.example.lovecalculator.data

import com.example.lovecalculator.data.api_servoce.LoveApiService

interface RegistrationView {

    fun showLoading()
    fun hideLoading()
    fun showSuccessResult(result: LoveModel)
    fun showError(errorMessage: String)

}