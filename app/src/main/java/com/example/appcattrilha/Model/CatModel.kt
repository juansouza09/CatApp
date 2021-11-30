package com.example.appcattrilha.Model

import com.google.gson.annotations.SerializedName

class CatModel {
    var name: String? = null
    var image : Image? = null
    var imageurl: String? = null
        get() = image?.url
    @SerializedName("description")
    var desc: String? = null
    @SerializedName("temperament")
    var temperamento: String? = null
}

class Image {
    var url : String? = null
}