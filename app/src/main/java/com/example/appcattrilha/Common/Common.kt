package com.example.appcattrilha.Common

import com.example.appcattrilha.Network.APIService
import com.example.appcattrilha.Network.Retrofit
import retrofit2.create

object Common {
    var loggedUserId : Long? = null
    private const val BASE_URL = "https://api.thecatapi.com/v1/"
    val getAPIService : APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}