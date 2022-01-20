package com.example.appcattrilha.Network

import com.example.appcattrilha.Common.Common
import com.example.appcattrilha.Model.CatModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIService {
    @GET("breeds")
    fun getCatList(@Header("x-api-key") APIKey: String = "fe0c32fc-fdf0-4532-88a0-dcc3ee362d0f"): Call<MutableList<CatModel>>


    fun getFavoritos(
        userId: String = Common.loggedUserId.toString()
    )
}