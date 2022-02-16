package com.example.appcattrilha.Network

import com.example.appcattrilha.Common.Common
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.Model.Favorite
import com.example.appcattrilha.Model.FavoriteResponse
import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @GET("breeds")
    fun getCatList(@Header("x-api-key") APIKey: String = "fe0c32fc-fdf0-4532-88a0-dcc3ee362d0f"): Call<MutableList<CatModel>>


    @GET("favourites")
    fun getCatListFavo(
        @Query("sub_id") loggedUserId : String,
        @Header("x-api-key") APIKey: String = "fe0c32fc-fdf0-4532-88a0-dcc3ee362d0f"
    ): Call<MutableList<CatModel>>

    @POST("favourites")
    fun addFavoritos(
        @Body body: Favorite,
        @Header("x-api-key") APIKey: String = "fe0c32fc-fdf0-4532-88a0-dcc3ee362d0f"
    ): Call<FavoriteResponse>
}