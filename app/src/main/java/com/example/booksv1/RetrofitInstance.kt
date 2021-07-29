package com.example.booksv1

import com.example.booksv1.utils.Credenciales
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retroService: RetroService by lazy {
        Retrofit.Builder()
            .baseUrl(Credenciales.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroService::class.java)
    }
}