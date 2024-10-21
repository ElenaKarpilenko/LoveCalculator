package com.example.lovecalculator.data

import com.example.lovecalculator.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationPresenter(private val contract: RegistrationView.View): RegistrationView.Presenter {

    override fun getPercentage(firstName: String, secondName: String) {
        App().api.fetchPercentage(
            key = "ef2a376a4fmsh5d299d7f68ef44bp156b9cjsn917023ff7c0a",
            host = "love-calculator.p.rapidapi.com",
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, p1: Response<LoveModel>) {
                if (p1.isSuccessful && p1.body() != null) {
                    contract.showResult(p1.body()!!)
                } else {
                    contract.showError("Error : ${p1.message()}")
                }
            }

            override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {
                contract.showError("Failure: ${p1.message}")
            }
        })
    }
}
