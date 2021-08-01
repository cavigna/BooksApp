package com.example.booksv1.jsonmodels.modelshort

import com.google.gson.annotations.SerializedName

data class OtroMas(
    @SerializedName("volumeInfo")
    val info: Books
)
