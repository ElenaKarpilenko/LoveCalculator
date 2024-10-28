package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String?,
    @SerializedName("percentage")
    val percentage: String? = null,
    @SerializedName("result")
    val result: String?,
)