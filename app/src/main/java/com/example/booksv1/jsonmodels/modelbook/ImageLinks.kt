package com.example.booksv1.jsonmodels.modelbook


import com.google.gson.annotations.SerializedName

data class ImageLinks(
    @SerializedName("thumbnail")
    val thumbnail: String
)