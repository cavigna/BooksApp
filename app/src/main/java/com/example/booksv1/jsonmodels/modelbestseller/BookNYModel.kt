package com.example.booksv1.jsonmodels.modelbestseller


import com.google.gson.annotations.SerializedName

data class BookNYModel(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("last_modified")
    val lastModified: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: Results,
    @SerializedName("status")
    val status: String
)