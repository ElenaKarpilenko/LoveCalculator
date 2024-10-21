package com.example.lovecalculator.data

import com.example.lovecalculator.data.api_servoce.LoveApiService

interface RegistrationView {
    interface View {

        fun showResult(result: LoveModel)
        fun showError(message: String)
    }

    interface Presenter {
        fun getPercentage(firstName: String, secondName: String)
    }
}
