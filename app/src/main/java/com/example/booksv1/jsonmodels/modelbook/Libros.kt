package com.example.booksv1.jsonmodels.modelbook


import com.google.gson.annotations.SerializedName

data class Libros(
    @SerializedName("volumeInfo")
    val libro: Libro
)