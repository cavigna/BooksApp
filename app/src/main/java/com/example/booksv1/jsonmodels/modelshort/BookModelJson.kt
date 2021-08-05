package com.example.booksv1.jsonmodels.modelshort

import com.google.gson.annotations.SerializedName

data class BookModelJson(@SerializedName("items")val listado: List<ListadoLibros>)

data class ListadoLibros(
    @SerializedName("id")
    val id: String,

    @SerializedName("volumeInfo")
    val info: Books
)

data class Books(
    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("imageLinks")
    val linksImagenes: LinksImagenes,


    @SerializedName("authors")
    val authors: List<String>,


)


data class LinksImagenes(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)
