package com.example.booksv1.jsonmodels.modelshort

import com.google.gson.annotations.SerializedName

data class OtroMas(
    @SerializedName("volumeInfo")
    val info: Books2,

    @SerializedName("items")
    val listado: List<Books2>
){
    data class Books2(
        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("publishedDate")
        val publishedDate: String,

        @SerializedName("imageLinks")
        val linksImagenes: LinksImagenes2,


        @SerializedName("authors")
        val authors: List<String>,
    )

    data class LinksImagenes2(
        @SerializedName("smallThumbnail")
        val smallThumbnail: String,
        @SerializedName("thumbnail")
        val thumbnail: String
    )
}
