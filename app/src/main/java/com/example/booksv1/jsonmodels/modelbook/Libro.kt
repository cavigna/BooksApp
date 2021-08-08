package com.example.booksv1.jsonmodels.modelbook


import com.google.gson.annotations.SerializedName

data class Libro(

    @SerializedName("title")
    val title: String,

    @SerializedName("authors")
    val authors: List<String>,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,

    @SerializedName("previewLink")
    val previewLink: String,


    @SerializedName("canonicalVolumeLink")
    val canonicalVolumeLink: String





)