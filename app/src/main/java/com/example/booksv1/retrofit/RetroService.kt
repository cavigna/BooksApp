package com.example.booksv1.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.booksv1.jsonmodels.modellong.BookJson
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import com.example.booksv1.jsonmodels.modelshort.Books
import com.example.booksv1.jsonmodels.modelshort.ListadoLibros
import com.example.booksv1.jsonmodels.modelshort.OtroMas
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("volumes")
    suspend fun librosPorBusqueda(@Query ("q", encoded = true) palabra:String) :
            Response<BookModelJson?>


    @GET("volumes")
    suspend fun searchByName(@Query ("q", encoded = true) palabra:String) : Response<BookJson>

    @GET("volumes")
    suspend fun searchByQuery(@Query ("q", encoded = true) palabra:String? = null) : Response<BookModelJson>

    @GET("volumes")// => palabra:String? = null ME PERMITE poner el parametro como opcional!  palabra:String? = null
    suspend fun librosPorNombre(@Query ("q", encoded = true) palabra:String) :
            MutableLiveData<Response<BookModelJson>>

    @GET("volumes?q=aleph")
    suspend fun otroMas() : Response<OtroMas.Books2>

    @GET("volumes")
    suspend fun librosConLiveData(@Query ("q", encoded = true) palabra:String) :
            Response<BookModelJson?>


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