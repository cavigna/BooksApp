package com.example.booksv1.retrofit

import com.example.booksv1.utils.Credenciales
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    const val  BASE_URL = "https://www.googleapis.com/books/v1/"


    val retroService: RetroService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // ==>https://www.googleapis.com/books/
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroService::class.java)
    }

//    val retroServiceNy: RetroService by lazy{
//        Retrofit.Builder()
//            .baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=3hSD1cqOAunEXXGwHGAdzJGojIR89OEB")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(RetroService:: class.java)
//    }
}


/*

var lateinit algo,

class Persona{
val nombre,
val edad,



var  Nico :Persona = Persona(Nicolas, 30)
val Leo: Persona = Persona( Leo, 15)





 */