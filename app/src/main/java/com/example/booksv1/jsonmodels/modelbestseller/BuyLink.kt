package com.example.booksv1.jsonmodels.modelbestseller


import com.google.gson.annotations.SerializedName

data class BuyLink(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)