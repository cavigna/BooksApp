package com.example.booksv1.jsonmodels.modelbestseller


import com.google.gson.annotations.SerializedName

data class Isbn(
    @SerializedName("isbn10")
    val isbn10: String,
    @SerializedName("isbn13")
    val isbn13: String
)