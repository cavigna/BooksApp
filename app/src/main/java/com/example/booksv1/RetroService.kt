package com.example.booksv1

import com.example.booksv1.jsonmodels.BookJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {
    @GET("volumes")
    suspend fun searchByName(@Query ("q", encoded = true) palabra:String) : Response<BookJson>
    //suspend fun searchByName(@Query("param1") param1: String ) : Response<BookJson>
}

//https://www.googleapis.com/books/v1/volumes?q=el+aleph


/*
interface RetroService {
    @GET("volumes?q=aleph")
    suspend fun searchByName() : Response<BookJson>
    //suspend fun searchByName(@Query("param1") param1: String ) : Response<BookJson>
}

 */