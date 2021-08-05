package com.example.booksv1.repository

import android.util.Log
import com.example.booksv1.retrofit.RetroService
import com.example.booksv1.retrofit.RetroServiceNy

class BookRepository(val retroService: RetroService) {

    suspend fun searchByQuery() = retroService.searchByQuery()
    suspend fun librosPorNombre(palabra:String) = retroService.librosPorNombre(palabra)

    suspend fun librosPorLiveData(busqueda: String) = retroService.librosConLiveData(busqueda).body()

    suspend fun librosPorBusqueda(busqueda: String) = retroService.librosPorBusqueda(busqueda).body()

    suspend fun bestSellers() = retroService.bestSellers().body()


}

