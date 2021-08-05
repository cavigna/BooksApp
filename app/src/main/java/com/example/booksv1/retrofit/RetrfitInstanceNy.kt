package com.example.booksv1.retrofit

import com.example.booksv1.utils.Credenciales
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrfitInstanceNy {

    val retroServiceNy: RetroServiceNy by lazy{
        Retrofit.Builder()
            .baseUrl(Credenciales.BASE_URL_NY)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroServiceNy::class.java)
    }

}