package com.example.lovecalculator.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationPresenter(private val view: RegistrationView)  {

    fun calculatePercentage(firstName: String, secondName: String) {
        view.showLoading()

        LoveService.provideApi().fetchPercentage(
            firstName = firstName,
            host = "love-calculator.p.rapidapi.com",
            key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c",
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(
                call: Call<LoveModel>,
                response: Response<LoveModel>
            ) {
                view.hideLoading()
                if (response.isSuccessful && response.body() != null) {
                    view.showSuccessResult(response.body()!!)
                } else {
                    view.showError("Ошибка: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.hideLoading()
                view.showError("Ошибка сети: ${t.localizedMessage}")
            }
        })
    }
}