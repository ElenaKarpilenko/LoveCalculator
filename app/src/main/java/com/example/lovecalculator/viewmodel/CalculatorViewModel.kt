package com.example.lovecalculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.data.apiservice.LoveApiService
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val api: LoveApiService,
) : ViewModel() {

    val loveResultData = MutableLiveData<LoveModel>()
    val errorData = MutableLiveData<String>()

    fun getPercentage(firstName: String, secondName: String) {
        api.fetchPercentage(
            firstName = firstName,
            secondName = secondName,
            key = "7feead24fbmshdacc8cfdc5702cap159d4cjsn9b7673a34788",
            host = "love-calculator.p.rapidapi.com"
        ).enqueue(object : retrofit2.Callback<LoveModel> {

            override fun onResponse(
                call: retrofit2.Call<LoveModel>,
                response: retrofit2.Response<LoveModel>,
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val loveResult = response.body()!!
                    loveResultData.postValue(loveResult)
                } else {
                    errorData.postValue("Could not get a correct answer")
                }
            }

            override fun onFailure(call: retrofit2.Call<LoveModel>, t: Throwable) {
                errorData.postValue("Connection error")
            }
        })
    }
}
